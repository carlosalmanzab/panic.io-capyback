package com.capy.back.user.service;

import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.dto.UserOutDTO;

public interface IUserManagementService {

    UserDTO getUserByEmail(String email);

    UserOutDTO getUsers(Long id);

    UserOutDTO saveUser(UserDTO userDTO);
    UserOutDTO verifyPassword(String user, String password);
}
