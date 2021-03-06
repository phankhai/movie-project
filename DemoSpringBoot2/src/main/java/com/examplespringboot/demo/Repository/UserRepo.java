package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

    @Query("SELECT u FROM users u WHERE u.id = :id")
    User findByidString(@Param("id") String id);

    @Query("SELECT u FROM users u WHERE u.email = :email")
    User findByEmail(@Param("email") String email);

    @Query("SELECT u FROM users u WHERE u.fullname like %:name%")
    List<User> searchUserByName(@Param("name") String name);
    


}
