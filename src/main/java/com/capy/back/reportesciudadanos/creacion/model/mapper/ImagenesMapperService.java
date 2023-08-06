package com.capy.back.reportesciudadanos.creacion.model.mapper;

import com.capy.back.reportesciudadanos.creacion.model.dto.ImagenesDTO;
import com.capy.back.reportesciudadanos.creacion.model.entity.Imagenes;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImagenesMapperService {
    private final ModelMapper modelMapper;

    @Autowired
    public ImagenesMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ImagenesDTO toDTO(Imagenes imagenes) {
        return modelMapper.map(imagenes, ImagenesDTO.class);
    }

    public Imagenes toEntity(ImagenesDTO imagenesDTO) {
        return modelMapper.map(imagenesDTO, Imagenes.class);
    }
}
