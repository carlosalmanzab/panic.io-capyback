package com.capy.back.usuario.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CP_USUARIO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {
    @Id
    @Column(name = "CPIDUSUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CP_USUARIO_SEQ")
    private Long id;
    @Column(name = "CPNOMBRE")
    private String nombre;
    @Column(name = "CPSEGUNDONOMBRE")
    private String segundoNombre;
    @Column(name = "CPAPELLIDO")
    private String apellido;
    @Column(name = "CPSEGUNDOAPELLIDO")
    private String segundoApellido;
    @Column(name = "CPEMAIL")
    private String email;
    @Column(name = "CPPASSWORD")
    private String password;
    @Column(name = "CPCELULAR")
    private String celular;
    @Column(name = "CPDIRECCION")
    private String direccion;
    @Column(name = "CPCIUDAD")
    private String ciudad;
    @Column(name = "CPPAIS")
    private String pais;
    @Column(name = "CPBARRIO")
    private String bario;
    @Column(name = "CPDOCUMENTOIDENTIDAD")
    private String documentoIdentidad;
}
