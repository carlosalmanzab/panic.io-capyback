package com.capy.back.localizacion.service.impl;

import com.capy.back.localizacion.model.dto.BarrioDTO;
import com.capy.back.localizacion.model.dto.BarrioOutDTO;
import com.capy.back.localizacion.model.entity.Barrio;
import com.capy.back.localizacion.model.mapper.BarrioMapperService;
import com.capy.back.localizacion.repository.IBarrioRepository;
import com.capy.back.localizacion.service.IBarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BarrioService implements IBarrioService {
    @Autowired
    IBarrioRepository barrioRepository;

    @Autowired
    BarrioMapperService barrioMapperService;

    @Override
    public BarrioOutDTO listarBarrios() {
        BarrioOutDTO barrioOutDTO = new BarrioOutDTO();
        List<Barrio> barrioList = barrioRepository.findAll();

        if (barrioList.isEmpty()) {
            barrioOutDTO.setMensajeError("No se encontraron barrios");
            return barrioOutDTO;
        }
        List<BarrioDTO> barrioDTOList = barrioList.stream().map(barrioMapperService::toDTO).collect(Collectors.toList());
        barrioOutDTO.setBarrioDTOList(barrioDTOList);
        barrioOutDTO.setTotalBarrios((long) barrioDTOList.size());
        return barrioOutDTO;

    }

    @Override
    public BarrioOutDTO listarBarriosPorComuna(Long idComuna) {
        BarrioOutDTO barrioOutDTO = new BarrioOutDTO();
        List<Barrio> barrioList = barrioRepository.findAllByIdComuna(idComuna);

        if (barrioList.isEmpty()) {
            barrioOutDTO.setMensajeError("No se encontraron barrios");
            return barrioOutDTO;
        }
        List<BarrioDTO> barrioDTOList = barrioList.stream().map(barrioMapperService::toDTO).collect(Collectors.toList());
        barrioOutDTO.setBarrioDTOList(barrioDTOList);
        barrioOutDTO.setTotalBarrios((long) barrioDTOList.size());
        return barrioOutDTO;
    }
}
