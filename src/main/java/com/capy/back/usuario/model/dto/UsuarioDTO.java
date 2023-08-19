package com.capy.back.usuario.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String segundoNombre;
    private String apellido;
    private String segundoApellido;
    private String email;
    private String password;
    private String celular;
    private String direccion;
    private String ciudad;
    private String pais;
    private String barrio;
    private String documentoIdentidad;
}
