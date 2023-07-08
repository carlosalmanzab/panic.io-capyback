package com.capy.back.shared.dtos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String department;
    private String dni;
}
