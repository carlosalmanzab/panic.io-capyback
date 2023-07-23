package com.capy.back.usuario.service;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.compartidos.enums.TipoIdentificacionEnum;
import com.capy.back.usuario.model.dto.UsuarioDTO;
import com.capy.back.usuario.model.dto.UsuarioOutDTO;

public interface IGestionUsuarioService {

    UsuarioDTO getUserByEmail(String email);

    UsuarioOutDTO obtenerUsuarios(Long id);

    ResultDTO guardarUsuario(UsuarioDTO usuarioDTO);

    UsuarioOutDTO verificarPassword(String user, String password);

    TipoIdentificacionEnum[] obtenerTiposIdentificacion();

    Boolean existeUsuario(String email);

    Boolean existeUsuarioPorId(Long id);
}
