package com.capy.back.localizacion.controller;

import com.capy.back.localizacion.model.dto.ComunaOutDTO;
import com.capy.back.localizacion.service.IComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comuna")
public class ComunaController {

    @Autowired
    IComunaService comunaService;

    @GetMapping(path = "listarComunas")
    public ComunaOutDTO listarComunas() {
        return comunaService.listarComunas();
    }

}
