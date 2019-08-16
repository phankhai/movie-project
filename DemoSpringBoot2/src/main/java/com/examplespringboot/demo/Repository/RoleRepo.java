package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, String> {

    Role findRoleById(String id);

}
