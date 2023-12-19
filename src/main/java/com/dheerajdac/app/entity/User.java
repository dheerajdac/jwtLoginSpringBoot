package com.dheerajdac.app.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_detail")
public class User implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private Boolean accountNonExpired = true;

    @Column
    private Boolean accountNonLocked = true;

    @Column
    private Boolean credentialsNonExpired = true;

    @Column
    private Boolean enabled = true;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<UserRole> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }


    @Override
    public String getUsername() {
        return username;
    }


    @Override
    public boolean isAccountNonExpired() {
        return this.getAccountNonExpired();
    }


    @Override
    public boolean isAccountNonLocked() {
        return this.getAccountNonLocked();
    }


    @Override
    public boolean isCredentialsNonExpired() {
        return this.getCredentialsNonExpired();
    }


    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }

    @Override
    public String toString() {
        return "user";
    }
}
