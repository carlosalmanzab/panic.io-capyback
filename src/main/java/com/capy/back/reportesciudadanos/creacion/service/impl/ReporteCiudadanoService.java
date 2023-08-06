package com.capy.back.reportesciudadanos.creacion.service.impl;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.reportesciudadanos.creacion.model.dto.ImagenesDTO;
import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoDTO;
import com.capy.back.reportesciudadanos.creacion.model.entity.ReporteCiudadano;
import com.capy.back.reportesciudadanos.creacion.model.mapper.ImagenesMapperService;
import com.capy.back.reportesciudadanos.creacion.model.mapper.ReporteCiudadanoMapperService;
import com.capy.back.reportesciudadanos.creacion.repository.IImagenesRepository;
import com.capy.back.reportesciudadanos.creacion.repository.IReporteCiudadanoRepository;
import com.capy.back.reportesciudadanos.creacion.service.IReporteCiudadanoService;
import com.capy.back.reportesciudadanos.parametrizacion.service.IParametrizacionService;
import com.capy.back.usuario.service.IGestionUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class ReporteCiudadanoService implements IReporteCiudadanoService {

    @Autowired
    IReporteCiudadanoRepository reporteCiudadanoRepository;

    @Autowired
    IImagenesRepository imagenesRepository;

    @Autowired
    ReporteCiudadanoMapperService reporteCiudadanoMapperService;

    @Autowired
    ImagenesMapperService imagenesMapperService;

    /**
     * EXTERNOS AL PACKAGE
     */
    @Autowired
    IParametrizacionService parametrizacionService;
    @Autowired
    IGestionUsuarioService gestionUsuarioService;

    @Override
    public ResultDTO guardarReporteCiudadano(ReporteCiudadanoDTO reporteCiudadanoDTO) throws IOException {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setExito(Boolean.FALSE);

        if (reporteCiudadanoDTO == null) {
            resultDTO.setMensaje("El reporte ciudadano no puede ser nulo");
            return resultDTO;
        }

        if (!parametrizacionService.existeParametrizacionActivaPorId(reporteCiudadanoDTO.getIdParametrizacion()).booleanValue()) {
            resultDTO.setMensaje("No existe una parametrización activa con el id: " + reporteCiudadanoDTO.getIdParametrizacion());
            return resultDTO;
        }

        if (!gestionUsuarioService.existeUsuarioPorId(reporteCiudadanoDTO.getIdUsuario()).booleanValue()) {
            resultDTO.setMensaje("No existe un usuario con el id: " + reporteCiudadanoDTO.getIdUsuario());
            return resultDTO;
        }

        reporteCiudadanoDTO.setFechaCreacion(LocalDate.now());
        ReporteCiudadano reporteCiudadano = reporteCiudadanoMapperService.toEntity(reporteCiudadanoDTO);
        ReporteCiudadano reporteGuardado = reporteCiudadanoRepository.save(reporteCiudadano);
        ReporteCiudadanoDTO reporteCiudadanoDTOResult = reporteCiudadanoMapperService.toDTO(reporteGuardado);

        if (reporteCiudadanoDTO.getHayImagen() != null && reporteCiudadanoDTO.getHayImagen().booleanValue() == Boolean.TRUE) {
            if (reporteCiudadanoDTO.getImagen()!=null) {
                ImagenesDTO imagenesDTO = new ImagenesDTO();
                imagenesDTO.setImagen(reporteCiudadanoDTO.getImagen());
                imagenesDTO.setIdReporteCiudadano(reporteCiudadanoDTOResult.getIdReporteCiudadano());
                imagenesRepository.save(imagenesMapperService.toEntity(imagenesDTO));
            } else {
                for(byte[] imagen : reporteCiudadanoDTO.getImagenes()){
                    ImagenesDTO imagenesDTO = new ImagenesDTO();
                    imagenesDTO.setImagen(imagen);
                    imagenesDTO.setIdReporteCiudadano(reporteCiudadanoDTOResult.getIdReporteCiudadano());
                    imagenesRepository.save(imagenesMapperService.toEntity(imagenesDTO));
                }
            }
        }

        resultDTO.setExito(Boolean.TRUE);
        resultDTO.setMensaje("Reporte ciudadano guardado exitosamente");
        return resultDTO;

    }
}
