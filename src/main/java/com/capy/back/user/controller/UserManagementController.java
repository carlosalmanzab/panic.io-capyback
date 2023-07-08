package com.capy.back.user.controller;

import com.capy.back.user.model.dto.UserDTO;
import com.capy.back.user.model.dto.UserOutDTO;
import com.capy.back.user.service.IUserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user-management")
public class UserManagementController {

    @Autowired
    IUserManagementService userManagementService;

    @GetMapping()
    public UserOutDTO getUsers(@RequestParam(name = "id", required = false) Long id) {
        return userManagementService.getUsers(id);
    }

    @PostMapping(path = "save-user")
    public UserOutDTO saveUser(@Valid @RequestBody UserDTO userDTO) {
        return userManagementService.saveUser(userDTO);
    }

    @PostMapping(path = "verify-password")
    public UserOutDTO verifyPassword(@RequestParam(name = "user") String user, @RequestParam(name = "password") String password) {
        return userManagementService.verifyPassword(user, password);
    }
}
