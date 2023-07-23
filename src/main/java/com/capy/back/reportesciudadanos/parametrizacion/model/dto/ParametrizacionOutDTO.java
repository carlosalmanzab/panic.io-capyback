package com.capy.back.reportesciudadanos.parametrizacion.model.dto;

import com.capy.back.compartidos.dtos.ResultDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ParametrizacionOutDTO extends ResultDTO {
    private List<ParametrizacionDTO> parametrizacionDTOList;
    private ParametrizacionDTO parametrizacionDTO;
}
