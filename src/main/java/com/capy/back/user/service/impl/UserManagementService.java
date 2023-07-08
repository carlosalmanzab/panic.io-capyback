package com.capy.back.user.service.impl;

import com.capy.back.security.PasswordEncoder;
import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.dto.UserOutDTO;
import com.capy.back.user.model.entity.User;
import com.capy.back.user.model.mapper.UserMapperService;
import com.capy.back.user.repository.IUserRepository;
import com.capy.back.user.service.IUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.capy.back.shared.messages.errormessages.ErrorMessagesConstants.USERS_NOT_FOUND;
import static com.capy.back.shared.messages.errormessages.ErrorMessagesConstants.USER_NULL;
import static com.capy.back.shared.messages.successmensages.SuccessMessagesConstants.USERS_FOUNDS;
import static com.capy.back.shared.messages.successmensages.SuccessMessagesConstants.USER_SAVE_SUCCESSFULLY;

@Service
public class UserManagementService implements IUserManagementService {
    PasswordEncoder passwordEncoder = new PasswordEncoder();
    @Autowired
    IUserRepository userRepository;

    @Autowired
    UserMapperService userMapperService;

    @Override
    public UserOutDTO saveUser(UserDTO userDTO) {
        UserOutDTO userOutDTO = new UserOutDTO();
        userOutDTO.setExito(Boolean.FALSE);

        if (userDTO == null) {
            userOutDTO.setMensaje(USER_NULL);
            return userOutDTO;
        }

        userDTO.setPassword(passwordEncoder.encodePassword(userDTO.getPassword()));

        userRepository.save(userMapperService.toEntity(userDTO));
        userOutDTO.setExito(Boolean.TRUE);
        userOutDTO.setMensaje(USER_SAVE_SUCCESSFULLY);
        return userOutDTO;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapperService.toDTO(userRepository.findByEmail(email));
    }


    @Override
    public UserOutDTO getUsers(Long id) {
        UserOutDTO userOutDTO = new UserOutDTO();
        List<UserDTO> userDTOS;

        userOutDTO.setExito(Boolean.FALSE);
        List<User> users;
        if (id == null) {
            users = userRepository.findAll();
        } else {
            Optional<User> user = userRepository.findById(id);
            users = user.map(List::of).orElseGet(List::of);
        }

        if (users.isEmpty()) {
            userOutDTO.setMensaje(USERS_NOT_FOUND);
            return userOutDTO;
        }

        userDTOS = users.stream().map(userMapperService::toDTO).collect(Collectors.toList());

        userOutDTO.setUsers(userDTOS);
        userOutDTO.setExito(Boolean.TRUE);
        userOutDTO.setMensaje(USERS_FOUNDS);
        return userOutDTO;
    }

    @Override
    public UserOutDTO verifyPassword(String email, String password) {
        UserOutDTO userOutDTO = new UserOutDTO();
        userOutDTO.setExito(Boolean.FALSE);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            userOutDTO.setMensaje(USERS_NOT_FOUND);
            return userOutDTO;
        }
        UserDTO userDTO = userMapperService.toDTO(user);
        if (userDTO != null && (passwordEncoder.verifyPassword(password, userDTO.getPassword()))) {
            userOutDTO.setExito(Boolean.TRUE);
            userOutDTO.setMensaje(USERS_FOUNDS);
            userDTO.setPassword(null);
            userOutDTO.setUser(userDTO);
            return userOutDTO;

        }
        userOutDTO.setMensaje(USERS_NOT_FOUND);
        return userOutDTO;
    }
}
