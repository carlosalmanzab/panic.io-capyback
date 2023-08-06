package com.capy.back.reportesciudadanos.consultas.controller;

import com.capy.back.reportesciudadanos.consultas.service.IConsultasService;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("reportesCiudadanos/consultas")
public class ConsultasController {

    @Autowired
    IConsultasService consultasService;

    @GetMapping(path = "obtenerReportesCiudadanos")
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanos() {
        return consultasService.obtenerReportesCiudadanos();
    }

    @GetMapping(path = "obtenerUltimosReportesCiudadanos")
    public ReporteCiudadanoOutDTO obtenerUltimosReportesCiudadanos() {
        return consultasService.obtenerUltimosReportesCiudadanos();
    }

    @GetMapping(path = "obtenerReportesCiudadanosPorUsuario")
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorUsuario(@RequestParam(name = "idUsuario") Long idUsuario) {
        return consultasService.obtenerReportesCiudadanosPorUsuario(idUsuario);
    }

    @GetMapping(path = "obtenerReportesCiudadanosPorTipoReporte")
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorTipoReporte(@RequestParam(name = "idParametriacionReporte") Long id) {
        return consultasService.obtenerReportesCiudadanosPorTipoReporte(id);
    }

    @GetMapping(path = "obtenerReportesCiudadanosPorLocalidad")
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorLocalidad(@RequestParam(name = "localidad") String localidad) {
        return consultasService.obtenerReportesCiudadanosPorLocalidad(localidad);
    }

    @GetMapping(path = "obtenerReportesCiudadanosPorFechaCreacion")
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorFechaCreacion(@RequestParam(name = "fechaInicio") LocalDate fechaInicio, @RequestParam(name = "fechaFin") LocalDate fechaFin) {
        return consultasService.obtenerReportesCiudadanosPorFechaCreacion(fechaInicio, fechaFin);
    }

    @GetMapping(path = "obtenerDetallesReporteCiudadano")
    public ReporteCiudadanoOutDTO obtenerDetallesReporteCiudadano(@RequestParam(name = "idReporte") Long idReporte) {
        return consultasService.obtenerDetallesReporteCiudadano(idReporte);
    }
}
