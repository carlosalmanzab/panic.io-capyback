package com.capy.back.localizacion.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CP_BARRIO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Barrio {
    @Id
    @Column(name = "CPIDBARRIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_BARRIO_SEQ")
    private Long id;
    @Column(name = "CPNOMBRE")
    private String nombre;
    @Column(name = "CPCOMUNA")
    private String comuna;
}
