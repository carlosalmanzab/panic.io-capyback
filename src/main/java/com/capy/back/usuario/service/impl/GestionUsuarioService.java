package com.capy.back.usuario.service.impl;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.compartidos.enums.TipoIdentificacionEnum;
import com.capy.back.seguridad.PasswordEncoder;
import com.capy.back.usuario.model.dto.UsuarioDTO;
import com.capy.back.usuario.model.dto.UsuarioOutDTO;
import com.capy.back.usuario.model.entity.Usuario;
import com.capy.back.usuario.model.mapper.UsuarioMapperService;
import com.capy.back.usuario.repository.IUserRepository;
import com.capy.back.usuario.service.IGestionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.capy.back.compartidos.messages.errormessages.ErrorMessagesConstants.USERS_NOT_FOUND;
import static com.capy.back.compartidos.messages.errormessages.ErrorMessagesConstants.USER_NULL;
import static com.capy.back.compartidos.messages.successmensages.SuccessMessagesConstants.USERS_FOUNDS;
import static com.capy.back.compartidos.messages.successmensages.SuccessMessagesConstants.USER_SAVE_SUCCESSFULLY;

@Service
public class GestionUsuarioService implements IGestionUsuarioService {
    PasswordEncoder passwordEncoder = new PasswordEncoder();
    @Autowired
    IUserRepository userRepository;

    @Autowired
    UsuarioMapperService usuarioMapperService;

    @Override
    public ResultDTO guardarUsuario(UsuarioDTO usuarioDTO) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setExito(Boolean.FALSE);

        if (usuarioDTO == null) {
            resultDTO.setMensaje(USER_NULL);
            return resultDTO;
        }

        usuarioDTO.setPassword(passwordEncoder.encodePassword(usuarioDTO.getPassword()));

        userRepository.save(usuarioMapperService.toEntity(usuarioDTO));
        resultDTO.setExito(Boolean.TRUE);
        resultDTO.setMensaje(USER_SAVE_SUCCESSFULLY);
        return resultDTO;
    }

    @Override
    public UsuarioDTO getUserByEmail(String email) {
        return usuarioMapperService.toDTO(userRepository.findByEmail(email));
    }


    @Override
    public UsuarioOutDTO obtenerUsuarios(Long id) {
        UsuarioOutDTO usuarioOutDTO = new UsuarioOutDTO();
        List<UsuarioDTO> usuarioDTOS;

        usuarioOutDTO.setExito(Boolean.FALSE);
        List<Usuario> usuarios;
        if (id == null) {
            usuarios = userRepository.findAll();
        } else {
            Optional<Usuario> user = userRepository.findById(id);
            usuarios = user.map(List::of).orElseGet(List::of);
        }

        if (usuarios.isEmpty()) {
            usuarioOutDTO.setMensaje(USERS_NOT_FOUND);
            return usuarioOutDTO;
        }

        for(Usuario usuario: usuarios){
            usuario.setPassword(null);
        }

        usuarioDTOS = usuarios.stream().map(usuarioMapperService::toDTO).collect(Collectors.toList());

        usuarioOutDTO.setUsuariosDTOList(usuarioDTOS);
        usuarioOutDTO.setExito(Boolean.TRUE);
        usuarioOutDTO.setMensaje(USERS_FOUNDS);
        return usuarioOutDTO;
    }

    @Override
    public UsuarioOutDTO verificarPassword(String email, String password) {
        UsuarioOutDTO usuarioOutDTO = new UsuarioOutDTO();
        usuarioOutDTO.setExito(Boolean.FALSE);
        Usuario usuario = userRepository.findByEmail(email);
        if (usuario == null) {
            usuarioOutDTO.setMensaje(USERS_NOT_FOUND);
            return usuarioOutDTO;
        }
        UsuarioDTO usuarioDTO = usuarioMapperService.toDTO(usuario);
        if (usuarioDTO != null && (passwordEncoder.verifyPassword(password, usuarioDTO.getPassword()))) {
            usuarioOutDTO.setExito(Boolean.TRUE);
            usuarioOutDTO.setMensaje(USERS_FOUNDS);
            usuarioDTO.setPassword(null);
            usuarioOutDTO.setUsuarioDTO(usuarioDTO);
            return usuarioOutDTO;

        }
        usuarioOutDTO.setMensaje(USERS_NOT_FOUND);
        return usuarioOutDTO;
    }

    @Override
    public TipoIdentificacionEnum[] obtenerTiposIdentificacion() {
        return TipoIdentificacionEnum.values();
    }

    @Override
    public Boolean existeUsuario(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public Boolean existeUsuarioPorId(Long id) {
        return userRepository.existsById(id);
    }
}
