package com.dheerajdac.app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dheerajdac.app.entity.User;
import com.dheerajdac.app.repository.UserRepo;

@Service
public class UserLoadService implements UserDetailsService{

    @Autowired
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepo.findByUsername(username);
        if(user == null) {
            throw new RuntimeException("user not found");
        }
        return user;
    }
    
}
