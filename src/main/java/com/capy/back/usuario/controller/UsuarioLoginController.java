package com.capy.back.usuario.controller;

import com.capy.back.usuario.model.dto.UsuarioOutDTO;
import com.capy.back.usuario.service.IUsuarioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loguin")
public class UsuarioLoginController {

    @Autowired
    IUsuarioLoginService userLoginService;

    @PostMapping()
    public UsuarioOutDTO login(@RequestParam(name = "email") String email , @RequestParam(name = "password") String password) {
        return userLoginService.login(email, password);

    }
}
