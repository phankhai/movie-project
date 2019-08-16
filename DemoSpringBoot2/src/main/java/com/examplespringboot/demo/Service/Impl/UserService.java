package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(String id);
    boolean insert(User model);
    boolean update(User model);
    boolean delete(User user);
    User findByEmail(String email);
    List<User> searchUserByName(String name);
}
