package com.capy.back.reportesciudadanos.parametrizacion.service.impl;

import com.capy.back.compartidos.dtos.ResultDTO;
import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import com.capy.back.reportesciudadanos.parametrizacion.model.dto.ParametrizacionDTO;
import com.capy.back.reportesciudadanos.parametrizacion.model.dto.ParametrizacionOutDTO;
import com.capy.back.reportesciudadanos.parametrizacion.model.entity.Parametrizacion;
import com.capy.back.reportesciudadanos.parametrizacion.model.mapper.ParametrizacionMapperService;
import com.capy.back.reportesciudadanos.parametrizacion.repository.IParametrizacionRepository;
import com.capy.back.reportesciudadanos.parametrizacion.service.IParametrizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParametrizacionService implements IParametrizacionService {

    @Autowired
    IParametrizacionRepository parametrizacionRepository;

    @Autowired
    ParametrizacionMapperService parametrizacionMapperService;


    @Override
    public ResultDTO guardarParametrizacion(ParametrizacionDTO parametrizacionDTO) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setExito(Boolean.FALSE);

        if (parametrizacionDTO == null) {
            resultDTO.setMensaje("No se ha enviado la información necesaria para guardar la parametrización");
            return resultDTO;
        }

        parametrizacionDTO.setFechaCreacion(LocalDateTime.now());
        Parametrizacion parametrizacion = parametrizacionMapperService.toEntity(parametrizacionDTO);
        parametrizacionRepository.save(parametrizacion);

        resultDTO.setExito(Boolean.TRUE);
        resultDTO.setMensaje("Se ha guardado la parametrización correctamente");
        return resultDTO;

    }


    private ParametrizacionOutDTO obtenerParametrizaciones() {
        ParametrizacionOutDTO parametrizacionOutDTO = new ParametrizacionOutDTO();
        parametrizacionOutDTO.setExito(Boolean.FALSE);

        List<Parametrizacion> parametrizacionList = parametrizacionRepository.findAll();
        if (parametrizacionList.isEmpty()) {
            parametrizacionOutDTO.setMensaje("No se encontraron parametrizaciones");
            return parametrizacionOutDTO;
        }

        parametrizacionOutDTO.setParametrizacionDTOList(parametrizacionList.stream().map(parametrizacionMapperService::toDTO).collect(Collectors.toList()));
        parametrizacionOutDTO.setExito(Boolean.TRUE);
        parametrizacionOutDTO.setMensaje("Se han encontrado " + parametrizacionList.size() + " parametrizaciones");
        return parametrizacionOutDTO;

    }

    @Override
    public ParametrizacionOutDTO obtenerParametrizacion(Long id) {
        ParametrizacionOutDTO parametrizacionOutDTO = new ParametrizacionOutDTO();
        parametrizacionOutDTO.setExito(Boolean.FALSE);

        if (id == null) {
            parametrizacionOutDTO.setMensaje("No se ha enviado el id de la parametrización");
            parametrizacionOutDTO = obtenerParametrizaciones();
            return parametrizacionOutDTO;
        }

        Parametrizacion parametrizacion = parametrizacionRepository.findById(id).orElse(null);
        if (parametrizacion == null) {
            parametrizacionOutDTO.setMensaje("No se ha encontrado la parametrización con id " + id);
            return parametrizacionOutDTO;
        }

        parametrizacionOutDTO.setParametrizacionDTO(parametrizacionMapperService.toDTO(parametrizacion));
        parametrizacionOutDTO.setExito(Boolean.TRUE);
        parametrizacionOutDTO.setMensaje("Se ha encontrado la parametrización con id " + id);
        return parametrizacionOutDTO;

    }

    @Override
    public ParametrizacionOutDTO actualizarParametrizacion(ParametrizacionDTO parametrizacionDTO) {
        ParametrizacionOutDTO parametrizacionOutDTO = new ParametrizacionOutDTO();
        parametrizacionOutDTO.setExito(Boolean.FALSE);

        if (parametrizacionDTO == null) {
            parametrizacionOutDTO.setMensaje("No se ha enviado la información necesaria para actualizar la parametrización");
            return parametrizacionOutDTO;
        }

        Parametrizacion parametrizacion = parametrizacionRepository.findById(parametrizacionDTO.getIdParametrizacion()).orElse(null);
        if (parametrizacion == null) {
            parametrizacionOutDTO.setMensaje("No se ha encontrado la parametrización con id " + parametrizacionDTO.getIdParametrizacion());
            return parametrizacionOutDTO;
        }

        parametrizacion.setNombre(parametrizacionDTO.getNombre());
        parametrizacion.setDescripcion(parametrizacionDTO.getDescripcion());
        parametrizacion.setUsuarioCreacion(parametrizacionDTO.getUsuarioCreacion());
        parametrizacion.setFechaCreacion(parametrizacionDTO.getFechaCreacion());
        parametrizacion.setUsuarioModificacion(parametrizacionDTO.getUsuarioModificacion());
        parametrizacion.setFechaModificacion(parametrizacionDTO.getFechaModificacion());
        parametrizacion.setEstado(parametrizacionDTO.getEstado());

        parametrizacionRepository.save(parametrizacion);

        parametrizacionOutDTO.setExito(Boolean.TRUE);
        parametrizacionOutDTO.setMensaje("Se ha actualizado la parametrización con id " + parametrizacionDTO.getIdParametrizacion());
        return parametrizacionOutDTO;
    }

    @Override
    public EstadoParametrizacionReporteEnum[] obtenerEstadoParametrizacion() {
        return EstadoParametrizacionReporteEnum.values();
    }

    @Override
    public ParametrizacionOutDTO obtenerParametrizacionesActivas() {
        ParametrizacionOutDTO parametrizacionOutDTO = new ParametrizacionOutDTO();
        parametrizacionOutDTO.setExito(Boolean.FALSE);

        List<Parametrizacion> parametrizacionList = parametrizacionRepository.findByEstado(EstadoParametrizacionReporteEnum.ACTIVO);
        if (parametrizacionList.isEmpty()) {
            parametrizacionOutDTO.setMensaje("No se encontraron parametrizaciones");
            return parametrizacionOutDTO;
        }

        parametrizacionOutDTO.setParametrizacionDTOList(parametrizacionList.stream().map(parametrizacionMapperService::toDTO).collect(Collectors.toList()));
        parametrizacionOutDTO.setExito(Boolean.TRUE);
        parametrizacionOutDTO.setMensaje("Se han encontrado " + parametrizacionList.size() + " parametrizaciones");
        return parametrizacionOutDTO;
    }

    @Override
    public ResultDTO cambiarEstadoParametrizacion(Long id, EstadoParametrizacionReporteEnum estadoParametrizacionReporteEnum) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setExito(Boolean.FALSE);

        if (id == null) {
            resultDTO.setMensaje("No se ha enviado el id de la parametrización");
            return resultDTO;
        }

        if (estadoParametrizacionReporteEnum == null) {
            resultDTO.setMensaje("No se ha enviado el estado de la parametrización");
            return resultDTO;
        }

        Parametrizacion parametrizacion = parametrizacionRepository.findById(id).orElse(null);
        if (parametrizacion == null) {
            resultDTO.setMensaje("No se ha encontrado la parametrización con id " + id);
            return resultDTO;
        }

        parametrizacion.setEstado(estadoParametrizacionReporteEnum);
        parametrizacionRepository.save(parametrizacion);

        resultDTO.setExito(Boolean.TRUE);
        resultDTO.setMensaje("Se ha actualizado el estado de la parametrización con id " + id);
        return resultDTO;
    }

    @Override
    public Boolean existeParametrizacionActivaPorId(Long id) {
        return parametrizacionRepository.existsByIdAndEstado(id, EstadoParametrizacionReporteEnum.ACTIVO);
    }
}
