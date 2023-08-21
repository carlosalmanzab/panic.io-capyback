package com.capy.back.localizacion.service;

import com.capy.back.localizacion.model.dto.BarrioOutDTO;

public interface IBarrioService {

    BarrioOutDTO listarBarrios();
    BarrioOutDTO listarBarriosPorComuna(Long idComuna);
}
