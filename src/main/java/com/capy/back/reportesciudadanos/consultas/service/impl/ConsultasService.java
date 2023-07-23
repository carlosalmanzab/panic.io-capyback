package com.capy.back.reportesciudadanos.consultas.service.impl;

import com.capy.back.reportesciudadanos.consultas.service.IConsultasService;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoOutDTO;
import com.capy.back.reportesciudadanos.creacion.model.entity.ReporteCiudadano;
import com.capy.back.reportesciudadanos.creacion.model.mapper.ReporteCiudadanoMapperService;
import com.capy.back.reportesciudadanos.creacion.repository.IReporteCiudadanoRepository;
import com.capy.back.reportesciudadanos.parametrizacion.service.IParametrizacionService;
import com.capy.back.usuario.model.mapper.UsuarioMapperService;
import com.capy.back.usuario.repository.IUserRepository;
import com.capy.back.usuario.service.IGestionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultasService implements IConsultasService {

    @Autowired
    IReporteCiudadanoRepository reporteCiudadanoRepository;

    @Autowired
    ReporteCiudadanoMapperService reporteCiudadanoMapperService;

    /**EXTERNOS AL PACKAGE*/
    @Autowired
    IParametrizacionService parametrizacionService;
    @Autowired
    IGestionUsuarioService gestionUsuarioService;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    UsuarioMapperService usuarioMapperService;


    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanos() {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findAll();

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje("No se encontraron reportes ciudadanos");
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje("Se encontraron " + reporteCiudadanoList.size() + " reportes ciudadanos");
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerUltimosReportesCiudadanos() {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findTop10ByOrderByIdReporteCiudadanoDesc();

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje("No se encontraron reportes ciudadanos");
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje("Se encontraron " + reporteCiudadanoList.size() + " reportes ciudadanos");
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorUsuario(Long id) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByIdUsuario(id);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje("No se encontraron reportes ciudadanos");
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje("Se encontraron " + reporteCiudadanoList.size() + " reportes ciudadanos");
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorTipoReporte(Long id) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByIdParametrizacionReporte(id);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje("No se encontraron reportes ciudadanos");
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje("Se encontraron " + reporteCiudadanoList.size() + " reportes ciudadanos");
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorLocalidad(String localidad) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByLocalidad(localidad);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje("No se encontraron reportes ciudadanos");
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje("Se encontraron " + reporteCiudadanoList.size() + " reportes ciudadanos");
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorFechaCreacion(LocalDate fechaInicio, LocalDate fechaFin) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje("No se encontraron reportes ciudadanos");
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje("Se encontraron " + reporteCiudadanoList.size() + " reportes ciudadanos");
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

}
