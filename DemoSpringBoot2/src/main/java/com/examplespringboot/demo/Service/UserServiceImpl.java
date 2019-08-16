package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.User;
import com.examplespringboot.demo.Repository.UserRepo;
import com.examplespringboot.demo.Service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepo.findByidString(id);
    }

    @Override
    public boolean insert(User model) {
        try {
            model.setId(String.valueOf(UUID.randomUUID()));
            model.setPassword(BCrypt.hashpw(model.getPassword(), BCrypt.gensalt()));
            userRepo.save(model);
            return true;
        } catch (RuntimeException r){
            r.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(User model) {
        User update = userRepo.findByidString(model.getId());
        update.setEmail(model.getEmail());
        update.setPassword(model.getPassword());
        update.setFullname(model.getFullname());
        update.setPhone(model.getPhone());
        update.setAddress(model.getAddress());
        update.setAvatar(model.getAvatar());
        update.setRoleId(model.getRoleId());
        if(userRepo.save(update) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean delete(User user) {
        userRepo.delete(user);
        return true;
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public List<User> searchUserByName(String name) {
        return userRepo.searchUserByName(name);
    }



}
