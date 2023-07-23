package com.capy.back.reportesciudadanos.parametrizacion.model.entity;

import com.capy.back.compartidos.enums.EstadoParametrizacionReporteEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CP_PARAMETRIZACION_REPORTES")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Parametrizacion {
    @Id
    @Column(name = "CPIDPARAMETRIZACION")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_PARAMETRIZACION_REPORTES_SEQ")
    private Long id;

    @Column(name = "CPNOMBRE")
    private String nombre;

    @Column(name = "CPDESCRIPCION")
    private String descripcion;

    @Column(name = "CPUSUARIOCREACION")
    private String usuarioCreacion;

    @Column(name = "CPFECHACREACION")
    private LocalDateTime fechaCreacion;

    @Column(name = "CPUSUARIOMODIFICACION")
    private String usuarioModificacion;

    @Column(name = "CPFECHAMODIFICACION")
    private LocalDateTime fechaModificacion;

    @Column(name = "CPESTADO")
    @Enumerated(EnumType.STRING)
    private EstadoParametrizacionReporteEnum estado;

}
