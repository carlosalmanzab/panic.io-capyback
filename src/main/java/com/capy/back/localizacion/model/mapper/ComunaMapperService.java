package com.capy.back.localizacion.model.mapper;

import com.capy.back.localizacion.model.dto.ComunaDTO;
import com.capy.back.localizacion.model.entity.Comuna;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComunaMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public ComunaMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ComunaDTO toDTO(Comuna comuna) {
        return modelMapper.map(comuna, ComunaDTO.class);
    }

    public Comuna toEntity(ComunaDTO comunaDTO) {
        return modelMapper.map(comunaDTO, Comuna.class);
    }
}
