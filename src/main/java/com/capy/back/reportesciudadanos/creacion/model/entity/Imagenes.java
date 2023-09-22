package com.capy.back.reportesciudadanos.creacion.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "CP_IMAGENES")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Imagenes {

    @Id
    @Column(name = "CPIDIMAGENES")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_IMAGENES_SEQ")
    private Long idImagen;

    @Lob
    @Column(name = "CPIMAGEN", columnDefinition = "LONGTEXT")
    private String imagen;

    @Column(name = "CPIDREPORTECIUDADANO")
    private Long idReporteCiudadano;
}
