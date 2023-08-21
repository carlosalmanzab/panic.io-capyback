package com.capy.back.localizacion.controller;

import com.capy.back.localizacion.model.dto.BarrioOutDTO;
import com.capy.back.localizacion.service.IBarrioService;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barrio")
public class BarrioController {

    @Autowired
    IBarrioService barrioService;

    @GetMapping(path = "listarBarrios")
    public BarrioOutDTO listarBarrios() {
        return barrioService.listarBarrios();
    }

    @GetMapping(path = "listarBarriosPorComuna")
    public BarrioOutDTO listarBarriosPorComuna(@RequestParam(name = "idComuna") Long idComuna) {
        return barrioService.listarBarriosPorComuna(idComuna);
    }
}
