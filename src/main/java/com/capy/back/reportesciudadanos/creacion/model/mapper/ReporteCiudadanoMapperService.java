package com.capy.back.reportesciudadanos.creacion.model.mapper;

import com.capy.back.reportesciudadanos.creacion.model.dto.ReporteCiudadanoDTO;
import com.capy.back.reportesciudadanos.creacion.model.entity.ReporteCiudadano;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteCiudadanoMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public ReporteCiudadanoMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ReporteCiudadanoDTO toDTO(ReporteCiudadano reporteCiudadano) {
        return modelMapper.map(reporteCiudadano, ReporteCiudadanoDTO.class);
    }

    public ReporteCiudadano toEntity(ReporteCiudadanoDTO reporteCiudadanoDTO) {
        return modelMapper.map(reporteCiudadanoDTO, ReporteCiudadano.class);
    }
}
