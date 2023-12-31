package com.capy.back.localizacion.service.impl;

import com.capy.back.localizacion.model.dto.ComunaDTO;
import com.capy.back.localizacion.model.dto.ComunaOutDTO;
import com.capy.back.localizacion.model.entity.Comuna;
import com.capy.back.localizacion.model.mapper.BarrioMapperService;
import com.capy.back.localizacion.model.mapper.ComunaMapperService;
import com.capy.back.localizacion.repository.IBarrioRepository;
import com.capy.back.localizacion.repository.IComunaRepository;
import com.capy.back.localizacion.service.IComunaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComunaService implements IComunaService {

    @Autowired
    IComunaRepository comunaRepository;

    @Autowired
    IBarrioRepository barrioRepository;

    @Autowired
    ComunaMapperService comunaMapperService;

    @Autowired
    BarrioMapperService barrioMapperService;

    @Override
    public ComunaOutDTO listarComunas() {
        ComunaOutDTO comunaOutDTO = new ComunaOutDTO();
        List<Comuna> comunaList = comunaRepository.findAll();

        if (comunaList.isEmpty()) {
            comunaOutDTO.setMensajeError("No se encontraron comunas");
            return comunaOutDTO;
        }

        List<ComunaDTO> comunaDTOList = comunaList.stream().map(comunaMapperService::toDTO).collect(Collectors.toList());

        //llenar barrios por comuna
        comunaDTOList.forEach(comunaDTO -> {
            comunaDTO.setBarrios(barrioRepository.findAllByIdComuna(comunaDTO.getId()).stream().map(barrioMapperService::toDTO).collect(Collectors.toList()));
        });

        comunaOutDTO.setComunaDTOList(comunaDTOList);
        comunaOutDTO.setTotalComunas((long) comunaDTOList.size());
        return comunaOutDTO;
    }
}
