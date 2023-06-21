package com.capy.back.user.service.impl;

import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.dto.UserOutDTO;
import com.capy.back.user.model.entity.User;
import com.capy.back.user.model.mapper.IUserMapper;
import com.capy.back.user.repository.IUserRepository;
import com.capy.back.user.service.IUserService;
import com.capy.back.shared.messages.searchresults.SearchResultsMessagesConstants;
import lombok.extern.slf4j.Slf4j;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Slf4j
public class UserService implements IUserService {
    private final IUserRepository userRepository;
    private final IUserMapper userMapper;

    public UserService(IUserRepository userRepository,
                       IUserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserOutDTO saveUser(UserDTO userDTO) {
        UserOutDTO userOutDTO = new UserOutDTO();
        userOutDTO.setExito(Boolean.FALSE);

        if (userDTO == null) {
            userOutDTO.setMensaje("El usuario no puede ser nulo");
            return userOutDTO;
        }

        userRepository.save(userMapper.toEntity(userDTO));
        userOutDTO.setExito(Boolean.TRUE);
        userOutDTO.setMensaje("Usuario guardado con exito");
        return userOutDTO;
    }

    @Override
    public UserOutDTO findUser(Long id) {
        return null;
    }

    @Override
    public UserOutDTO findUsers() {
        UserOutDTO userOutDTO = new UserOutDTO();
        List<UserDTO> userDTOS;

        userOutDTO.setExito(Boolean.FALSE);

        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            userOutDTO.setMensaje(SearchResultsMessagesConstants.USERS_NOT_FOUND);
            return userOutDTO;
        }

        userDTOS = users.stream().map(userMapper::toDTO).collect(Collectors.toList());

        userOutDTO.setUsers(userDTOS);
        userOutDTO.setExito(Boolean.TRUE);
        userOutDTO.setMensaje(SearchResultsMessagesConstants.USERS_FOUNDS);
        return userOutDTO;

    }


}
