package com.dheerajdac.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.dheerajdac.app.entity.User;
import com.dheerajdac.app.entity.UserRole;
import com.dheerajdac.app.enums.Privilege;
import com.dheerajdac.app.enums.Role;
import com.dheerajdac.app.model.RegisterRequest;
import com.dheerajdac.app.model.RegisterResponse;
import com.dheerajdac.app.repository.UserRepo;
import com.dheerajdac.app.repository.UserRoleRepo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class RegisterController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserRoleRepo userRoleRepo;

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(this.passwordEncoder.encode(request.getPassword()));
        UserRole role = new UserRole();
        role.setRole(Role.ROLE_ADMIN.getValue());
        role.setPrivilege(Privilege.READ.getValue());
        role.setUser(user);
        user.setRoles(List.of(role));
        user = userRepo.save(user);

        RegisterResponse respose = new RegisterResponse();
        respose.setUsername(user.getUsername());
        respose.setEmail(user.getEmail());
        respose.setRoles(user.getRoles().stream().map(UserRole::getAuthority).collect(Collectors.joining(",", "", "")));
    
        return respose;
    }
    
}
