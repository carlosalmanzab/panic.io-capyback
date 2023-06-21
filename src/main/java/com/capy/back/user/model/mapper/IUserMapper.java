package com.capy.back.user.model.mapper;

import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface IUserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "secondName", source = "secondName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "secondLastName", source = "secondLastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "dni", source = "dni")
    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}
