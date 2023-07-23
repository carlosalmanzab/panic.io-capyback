package com.capy.back.usuario.service.impl;

import com.capy.back.usuario.model.dto.UsuarioOutDTO;
import com.capy.back.usuario.service.IUsuarioLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginService implements IUsuarioLoginService {

    @Autowired
    GestionUsuarioService userManagementService;

    @Override
    public UsuarioOutDTO login(String email, String password) {
        return userManagementService.verificarPassword(email, password);
    }
}
