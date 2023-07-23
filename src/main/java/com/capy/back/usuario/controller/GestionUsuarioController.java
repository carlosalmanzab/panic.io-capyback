package com.capy.back.usuario.controller;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.compartidos.enums.TipoIdentificacionEnum;
import com.capy.back.usuario.model.dto.UsuarioDTO;
import com.capy.back.usuario.model.dto.UsuarioOutDTO;
import com.capy.back.usuario.service.IGestionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/gestionUsuario")
public class GestionUsuarioController {

    @Autowired
    IGestionUsuarioService gestionUsuarioService;

    @GetMapping(path = "obtenerUsuario")
    public UsuarioOutDTO obtenerUsuarios(@RequestParam(name = "id", required = false) Long id) {
        return gestionUsuarioService.obtenerUsuarios(id);
    }

    @PostMapping(path = "guardarUsuario")
    public ResultDTO guardarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return gestionUsuarioService.guardarUsuario(usuarioDTO);
    }

    @PostMapping(path = "verificarPassword")
    public UsuarioOutDTO verificarPassword(@RequestParam(name = "user") String user, @RequestParam(name = "password") String password) {
        return gestionUsuarioService.verificarPassword(user, password);
    }

    @GetMapping(path = "obtenerTiposIdentificacion")
    public TipoIdentificacionEnum[] obtenerTiposIdentificacion() {
        return gestionUsuarioService.obtenerTiposIdentificacion();
    }

    @GetMapping(path = "existeUsuario")
    public Boolean existeUsuario(@RequestParam(name = "email") String email) {
        return gestionUsuarioService.existeUsuario(email);
    }

}
