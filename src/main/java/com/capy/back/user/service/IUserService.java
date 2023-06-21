package com.capy.back.user.service;

import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.dto.UserOutDTO;

public interface IUserService {

    UserOutDTO findUser(Long id);

    UserOutDTO findUsers();

    UserOutDTO saveUser(UserDTO userDTO);
}
