package com.capy.back.reportesciudadanos.parametrizacion.controller;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import com.capy.back.reportesciudadanos.parametrizacion.model.dto.ParametrizacionDTO;
import com.capy.back.reportesciudadanos.parametrizacion.service.IParametrizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reportesCiudadanos/parametrizacion")
public class ParameterizationController {

    @Autowired
    IParametrizacionService parametrizacionService;


    @PostMapping(path = "guardarParametrizacion")
    public ResultDTO guardarParametrizacion(@RequestBody ParametrizacionDTO parametrizacionDTO) {
        return parametrizacionService.guardarParametrizacion(parametrizacionDTO);

    }

    @GetMapping(path = "obtenerParametrizacion")
    public ResultDTO obtenerParametrizacion(@RequestParam(name = "id", required = false) Long id) {
        return parametrizacionService.obtenerParametrizacion(id);
    }

    @PutMapping(path = "actualizarParametrizacion")
    public ResultDTO actualizarParametrizacion(@RequestBody ParametrizacionDTO parametrizacionDTO) {
        return parametrizacionService.actualizarParametrizacion(parametrizacionDTO);
    }

    @GetMapping(path = "obtenerEstadoParametrizacion")
    public EstadoParametrizacionReporteEnum[] obtenerEstadoParametrizacion() {
        return parametrizacionService.obtenerEstadoParametrizacion();
    }

    @GetMapping(path = "obtenerParametrizacionesActivas")
    public ResultDTO obtenerParametrizacionesActivas() {
        return parametrizacionService.obtenerParametrizacionesActivas();
    }

    @PutMapping(path = "cambiarEstadoParametrizacion")
    public ResultDTO cambiarEstadoParametrizacion(@RequestParam(name = "id") Long id, @RequestParam(name = "estado") EstadoParametrizacionReporteEnum estadoParametrizacionReporteEnum) {
        return parametrizacionService.cambiarEstadoParametrizacion(id, estadoParametrizacionReporteEnum);
    }

   @GetMapping(path = "existeParametrizacionActivaPorId")
    public Boolean existeParametrizacionActivaPorId(@RequestParam(name = "id") Long id) {
        return parametrizacionService.existeParametrizacionActivaPorId(id);
    }
}
