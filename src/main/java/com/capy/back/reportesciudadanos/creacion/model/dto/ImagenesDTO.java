package com.capy.back.reportesciudadanos.creacion.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImagenesDTO {
    private Long idImagen;
    private byte[] imagen;
    private Long idReporteCiudadano;

}
