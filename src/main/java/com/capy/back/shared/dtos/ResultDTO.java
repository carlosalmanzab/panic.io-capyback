package com.capy.back.shared.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultDTO {
    private String codigo;
    private String mensaje;
    private Boolean exito;
}
