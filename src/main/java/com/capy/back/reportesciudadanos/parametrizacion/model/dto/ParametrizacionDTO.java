package com.capy.back.reportesciudadanos.parametrizacion.model.dto;

import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParametrizacionDTO {

    private Long idParametrizacion;
    private String nombre;
    private String descripcion;
    private String usuarioCreacion;
    private LocalDateTime fechaCreacion;
    private String usuarioModificacion;
    private LocalDateTime fechaModificacion;
    private EstadoParametrizacionReporteEnum estado;

}
