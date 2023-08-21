package com.capy.back.reportesciudadanos.consultas.service.impl;

import com.capy.back.reportesciudadanos.consultas.service.IConsultasService;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoDTO;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoOutDTO;
import com.capy.back.reportesciudadanos.creacion.model.entity.ReporteCiudadano;
import com.capy.back.reportesciudadanos.creacion.model.mapper.ImagenesMapperService;
import com.capy.back.reportesciudadanos.creacion.model.mapper.ReporteCiudadanoMapperService;
import com.capy.back.reportesciudadanos.creacion.repository.IImagenesRepository;
import com.capy.back.reportesciudadanos.creacion.repository.IReporteCiudadanoRepository;
import com.capy.back.reportesciudadanos.parametrizacion.service.IParametrizacionService;
import com.capy.back.usuario.model.mapper.UsuarioMapperService;
import com.capy.back.usuario.repository.IUserRepository;
import com.capy.back.usuario.service.IGestionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultasService implements IConsultasService {

    private static final String SE_ENCONTRARON_REPORTES = "Se encontraron ";
    private static final String REPORTES_CIUDADANOS = " reportes ciudadanos";
    private static final String NO_SE_ENCONTRARON_REPORTES_CIUDADANOS = "No se encontraron reportes ciudadanos";

    @Autowired
    IReporteCiudadanoRepository reporteCiudadanoRepository;

    @Autowired
    ReporteCiudadanoMapperService reporteCiudadanoMapperService;

    @Autowired
    IImagenesRepository imagenesRepository;

    @Autowired
    ImagenesMapperService imagenesMapperService;

    /**
     * EXTERNOS AL PACKAGE
     */
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
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        List<ReporteCiudadanoDTO> reporteCiudadanoDTOList = reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList());

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje(SE_ENCONTRARON_REPORTES + reporteCiudadanoDTOList.size() + REPORTES_CIUDADANOS);
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoDTOList);

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerUltimosReportesCiudadanos() {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findTop10ByOrderByIdReporteCiudadanoDesc();


        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje(SE_ENCONTRARON_REPORTES + reporteCiudadanoList.size() + REPORTES_CIUDADANOS);
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorUsuario(Long id) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByIdUsuario(id);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje(SE_ENCONTRARON_REPORTES + reporteCiudadanoList.size() + REPORTES_CIUDADANOS);
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorTipoReporte(Long id) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByIdParametrizacionReporte(id);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje(SE_ENCONTRARON_REPORTES + reporteCiudadanoList.size() + REPORTES_CIUDADANOS);
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorLocalidad(String localidad) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByLocalidad(localidad);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje(SE_ENCONTRARON_REPORTES + reporteCiudadanoList.size() + REPORTES_CIUDADANOS);
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerReportesCiudadanosPorFechaCreacion(LocalDate fechaInicio, LocalDate fechaFin) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        List<ReporteCiudadano> reporteCiudadanoList = reporteCiudadanoRepository.findByFechaCreacionBetween(fechaInicio, fechaFin);

        if (reporteCiudadanoList.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setMensaje(SE_ENCONTRARON_REPORTES + reporteCiudadanoList.size() + REPORTES_CIUDADANOS);
        reporteCiudadanoOutDTO.setReporteCiudadanoDTOList(reporteCiudadanoList.stream().map(reporteCiudadanoMapperService::toDTO).collect(Collectors.toList()));

        return reporteCiudadanoOutDTO;
    }

    @Override
    public ReporteCiudadanoOutDTO obtenerDetallesReporteCiudadano(Long idReporte) {
        ReporteCiudadanoOutDTO reporteCiudadanoOutDTO = new ReporteCiudadanoOutDTO();
        reporteCiudadanoOutDTO.setExito(Boolean.FALSE);
        Optional<ReporteCiudadano> reporteCiudadano = reporteCiudadanoRepository.findById(idReporte);

        if (reporteCiudadano.isEmpty()) {
            reporteCiudadanoOutDTO.setMensaje(NO_SE_ENCONTRARON_REPORTES_CIUDADANOS);
            return reporteCiudadanoOutDTO;
        }

        ReporteCiudadanoDTO reporteCiudadanoDTO = reporteCiudadanoMapperService.toDTO(reporteCiudadano.get());

        reporteCiudadanoOutDTO.setExito(Boolean.TRUE);
        reporteCiudadanoOutDTO.setReporteCiudadano(reporteCiudadanoDTO);

        return reporteCiudadanoOutDTO;
    }

}
