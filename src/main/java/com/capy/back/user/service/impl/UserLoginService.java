package com.capy.back.user.service.impl;

import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.dto.UserOutDTO;
import com.capy.back.user.model.entity.User;
import com.capy.back.user.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService implements IUserLoginService {

    @Autowired
    UserManagementService userManagementService;

    @Override
    public UserOutDTO login(String email, String password) {
        return userManagementService.verifyPassword(email, password);
    }
}
