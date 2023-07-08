package com.capy.back.user.model.dto;

import com.sun.istack.NotNullM;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    @NotNullM(message = "El nombre no puede ser nulo")
    private String name;
    private String secondName;
    @NotNullM(message = "El apellido no puede ser nulo")
    private String lastName;
    private String secondLastName;
    @NotNullM(message = "El email no puede ser nulo")
    private String email;
    private String password;
    @NotNullM(message = "El telefono no puede ser nulo")
    private String phone;
    private String address;
    private String department;
    @NotNullM(message = "El dni no puede ser nulo")
    private String dni;
}
