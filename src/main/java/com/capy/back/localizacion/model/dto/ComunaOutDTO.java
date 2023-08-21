package com.capy.back.localizacion.model.dto;

import com.capy.back.compartidos.dtos.ResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComunaOutDTO extends ResultDTO {
    private List<ComunaDTO> comunaDTOList;
    private ComunaDTO comunaDTO;
    private Long totalComunas;
    private String mensajeError;
    private String mensajeOK;
}
