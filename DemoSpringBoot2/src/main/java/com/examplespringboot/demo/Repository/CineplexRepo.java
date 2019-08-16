package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.Cineplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CineplexRepo extends JpaRepository<Cineplex, Integer> {
}
