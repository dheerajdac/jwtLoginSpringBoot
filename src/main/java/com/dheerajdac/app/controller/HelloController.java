package com.dheerajdac.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dheerajdac.app.facade.UserFacade;
import com.dheerajdac.app.repository.UserRepo;

@RestController
public class HelloController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    UserFacade userFacade;
    
    @GetMapping("/api/")
    @PreAuthorize("hasAuthority('ADMIN:READ')")
    public String get() {
        return "hello world";
    }

    @GetMapping("/api/test")
    @PreAuthorize("hasAnyAuthority('SCOPE_ADMIN:READ')")
    public String gets() {
        return "hello test: " + userFacade.getUserId();
    }

    @GetMapping("/all")
    public Collection<? extends GrantedAuthority> getAll() {
        return SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    }
}
