package com.capy.back.localizacion.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CP_COMUNA")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comuna {
    @Id
    @Column(name = "CPIDCOMUNA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_COMUNA_SEQ")
    private Long id;

    @Column(name = "CPNOMBRE")
    private String nombre;

}
