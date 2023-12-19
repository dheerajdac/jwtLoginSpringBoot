package com.dheerajdac.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dheerajdac.app.entity.User;


@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    public User findByUsername(String username);
    
}
