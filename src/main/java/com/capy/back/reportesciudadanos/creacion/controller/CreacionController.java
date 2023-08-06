package com.capy.back.reportesciudadanos.creacion.controller;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoDTO;
import com.capy.back.reportesciudadanos.creacion.service.IReporteCiudadanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("reportesCiudadanos/creacion")
public class CreacionController {


    @Autowired
    IReporteCiudadanoService reporteCiudadanoService;

    @PostMapping(path = "guardarReporteCiudadano")
    public ResultDTO guardarReporteCiudadano(@RequestBody ReporteCiudadanoDTO reporteCiudadanoDTO) throws IOException {
        return reporteCiudadanoService.guardarReporteCiudadano(reporteCiudadanoDTO);

    }
}
