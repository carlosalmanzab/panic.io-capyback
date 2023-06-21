package com.capy.back.user.model.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CP_USUARIO")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @Column(name = "CPIDUSUARIO")
    private Long id;
    @Column(name = "CPNAME")
    private String name;

    @Column(name = "CPSECONDNAME")
    private String secondName;

    @Column(name = "CPLASTNAME")
    private String lastName;

    @Column(name = "CPSECONDLASTNAME")
    private String secondLastName;

    @Column(name = "CPEMAIL")
    private String email;

    @Column(name = "CPPASSWORD")
    private String password;

    @Column(name = "CPPHONE")
    private String phone;

    @Column(name = "CPADDRESS")
    private String address;

    @Column(name = "CPCITY")
    private String city;

    @Column(name = "CPCOUNTRY")
    private String country;

    @Column(name = "CPPOSTALCODE")
    private String postalCode;

    @Column(name = "CPDNI")
    private String dni;
}
