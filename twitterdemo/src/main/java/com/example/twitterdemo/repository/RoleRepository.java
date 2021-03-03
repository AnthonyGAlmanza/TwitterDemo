package com.example.twitterdemo.repository;

import com.example.twitterdemo.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {

    Role findByRole(String role);

}
