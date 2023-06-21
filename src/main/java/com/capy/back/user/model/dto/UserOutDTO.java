package com.capy.back.user.model.dto;

import com.capy.back.shared.dtos.ResultDTO;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserOutDTO extends ResultDTO {

    List<UserDTO> users;

}
