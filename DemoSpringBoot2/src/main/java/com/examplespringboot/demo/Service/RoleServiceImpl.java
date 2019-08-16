package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.Role;
import com.examplespringboot.demo.Repository.RoleRepo;
import com.examplespringboot.demo.Service.Impl.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role findRoleById(String id) {
        return roleRepo.findRoleById(id);
    }

    @Override
    public boolean insert(Role model) {
        model.setId(String.valueOf(UUID.randomUUID()));
        roleRepo.save(model);
        return true;
    }

    @Override
    public boolean update(Role model) {
        Role update = roleRepo.findRoleById(model.getId());
        update.setDescription(model.getDescription());
        update.setName(model.getName());
        if(roleRepo.save(update) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean delete(Role role) {
        roleRepo.delete(role);
        return true;
    }

    @Override
    public Role insertApi(Role model) {
        roleRepo.save(model);
        return model;
    }
}
