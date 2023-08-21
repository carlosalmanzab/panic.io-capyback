package com.capy.back.localizacion.model.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ComunaDTO {

    private Long id;
    private String nombre;
    private List<BarrioDTO> barrios;
}
