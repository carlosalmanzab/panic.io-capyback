package com.capy.back.user.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String country;
    private String postalCode;
    private String dni;
}
