package com.capy.back.localizacion.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BarrioDTO {
    private Long id;
    private String nombre;
    private String comuna;
}
