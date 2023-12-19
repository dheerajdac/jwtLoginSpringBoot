package com.dheerajdac.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dheerajdac.app.entity.UserRole;


@Repository
public interface UserRoleRepo extends CrudRepository<UserRole, Long>{
    
}
