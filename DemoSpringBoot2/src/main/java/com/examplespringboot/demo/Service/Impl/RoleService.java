package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
    Role findRoleById(String id);
    boolean insert(Role model);
    Role insertApi(Role model);
    boolean update(Role model);
    boolean delete(Role user);

}
