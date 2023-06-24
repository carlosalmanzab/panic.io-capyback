package com.capy.back.user.controller;

import com.capy.back.user.model.dto.UserOutDTO;
import com.capy.back.user.service.IUserLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-login")
public class UserLoginController {

    @Autowired
    IUserLoginService userLoginService;

    @PostMapping()
    public UserOutDTO login(@RequestParam(name = "user") String user , @RequestParam(name = "password") String password) {
        return userLoginService.login(user, password);

    }
}
