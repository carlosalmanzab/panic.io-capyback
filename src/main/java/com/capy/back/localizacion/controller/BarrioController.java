package com.capy.back.localizacion.controller;

import com.capy.back.localizacion.model.dto.BarrioOutDTO;
import com.capy.back.localizacion.service.IBarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barrio")
public class BarrioController {

    @Autowired
    IBarrioService barrioService;

    @GetMapping(path = "listarBarrios")
    public BarrioOutDTO listarBarrios() {
        return barrioService.listarBarrios();

    }
}
