package com.dheerajdac.app.entity;

import org.springframework.security.core.GrantedAuthority;

import com.dheerajdac.app.enums.Privilege;
import com.dheerajdac.app.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class UserRole implements GrantedAuthority{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 1)
    private Integer role;

    @Column(length = 1)
    private Integer privilege;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Override
    public String getAuthority() {
        return Role.getRoleByValue(this.role) + "_" + Privilege.getPrivilegeByValue(this.privilege);
    }

    @Override
    public String toString() {
        return "userRole";
    }

}
