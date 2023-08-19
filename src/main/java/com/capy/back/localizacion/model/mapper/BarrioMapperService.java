package com.capy.back.localizacion.model.mapper;

import com.capy.back.localizacion.model.dto.BarrioDTO;
import com.capy.back.localizacion.model.entity.Barrio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarrioMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public BarrioMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BarrioDTO toDTO(Barrio barrio) {
        return modelMapper.map(barrio, BarrioDTO.class);
    }

    public Barrio toEntity(BarrioDTO barrioDTO) {
        return modelMapper.map(barrioDTO, Barrio.class);
    }
}
