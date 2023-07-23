package com.capy.back.reportesciudadanos.parametrizacion.model.mapper;

import com.capy.back.reportesciudadanos.parametrizacion.model.dto.ParametrizacionDTO;
import com.capy.back.reportesciudadanos.parametrizacion.model.entity.Parametrizacion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParametrizacionMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public ParametrizacionMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ParametrizacionDTO toDTO(Parametrizacion parametrizacion) {
        return modelMapper.map(parametrizacion, ParametrizacionDTO.class);
    }

    public Parametrizacion toEntity(ParametrizacionDTO parametrizacionDTO) {
        return modelMapper.map(parametrizacionDTO, Parametrizacion.class);
    }
}
