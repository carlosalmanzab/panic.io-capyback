package com.capy.back.usuario.service;

import com.capy.back.usuario.model.dto.UsuarioOutDTO;

public interface IUsuarioLoginService {
    UsuarioOutDTO login(String email, String password);
}
