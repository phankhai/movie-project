package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.Cineplex;

import java.util.List;

public interface CineplexService {

    List<Cineplex> findAll();
    Cineplex findById(int id);
    boolean insert(Cineplex model);
    boolean update(Cineplex model);
    boolean delete(int id);

}
