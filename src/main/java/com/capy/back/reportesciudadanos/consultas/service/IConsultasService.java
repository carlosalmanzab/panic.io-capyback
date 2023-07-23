package com.capy.back.reportesciudadanos.consultas.service;

import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoOutDTO;

import java.time.LocalDate;

public interface IConsultasService {

    ReporteCiudadanoOutDTO obtenerReportesCiudadanos();
    ReporteCiudadanoOutDTO obtenerUltimosReportesCiudadanos();
    ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorUsuario(Long id);
    ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorTipoReporte(Long id);
    ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorLocalidad(String localidad);
    ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorFechaCreacion(LocalDate fechaInicio, LocalDate fechaFin);

    /**
    Long cantidadReportesCiudadanos();
    Long cantidadReportesCiudadanosPorUsuario(Long id);
    Long cantidadReportesCiudadanosPorTipoReporte(Long id);
    Long cantidadReportesCiudadanosPorLocalidad(Long id);
    Long cantidadReportesCiudadanosPorUsuarioYTipoReporte(Long idUsuario, Long idTipoReporte);
    Long cantidadReportesCiudadanosPorUsuarioYLocalidad(Long idUsuario, Long idLocalidad);
    Long cantidadReportesCiudadanosPorTipoReporteYLocalidad(Long idTipoReporte, Long idLocalidad);
    Long cantidadReportesCiudadanosPorUsuarioYTipoReporteYLocalidad(Long idUsuario, Long idTipoReporte, Long idLocalidad);
    Long cantidadReportesCiudadanosPorTipoReporteYLocalidadYFecha(Long idTipoReporte, Long idLocalidad, String fechaInicio, String fechaFin);
    Long cantidadReportesCiudadanosPorUsuarioYTipoReporteYLocalidadYFecha(Long idUsuario, Long idTipoReporte, Long idLocalidad, String fechaInicio, String fechaFin);
    Long cantidadReportesCiudadanosPorTipoReporteYFecha(Long idTipoReporte, String fechaInicio, String fechaFin);
    Long cantidadReportesCiudadanosPorUsuarioYFecha(Long idUsuario, String fechaInicio, String fechaFin);
    Long cantidadReportesCiudadanosPorLocalidadYFecha(Long idLocalidad, String fechaInicio, String fechaFin);
*/
}
