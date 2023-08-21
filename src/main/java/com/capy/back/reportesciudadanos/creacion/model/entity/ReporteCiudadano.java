package com.capy.back.reportesciudadanos.creacion.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "CP_REPORTES_CIUDADANO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReporteCiudadano {
    @Id
    @Column(name = "CPIDREPORTECIUDADANO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_REPORTES_CIUDADANO_SEQ")
    private Long idReporteCiudadano;

    @Column(name = "CPIDPARAMETRIZACIONREPORTE")
    private Long idParametrizacionReporte;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "CPIMAGEN", columnDefinition = "LONGBLOB")
    private byte[] imagen;

    @Column(name = "CPHAYIMAGEN")
    private Boolean hayImagen;

    @Column(name = "CPDESCRIPCION")
    private String descripcion;

    @Column(name = "CPIDUSUARIO")
    private Long idUsuario;

    @Column(name = "CPFECHACREACION")
    private LocalDate fechaCreacion;

    @Column(name = "CPLOCALIDAD")
    private String localidad;

    @Column(name = "CPLATITUD")
    private BigDecimal latitud;

    @Column(name = "CPLONGITUD")
    private BigDecimal longitud;

}
