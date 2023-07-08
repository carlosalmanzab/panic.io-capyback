package com.capy.back.user.service;

import com.capy.back.user.model.dto.UserOutDTO;

public interface IUserLoginService {
    UserOutDTO login(String email, String password);
}
