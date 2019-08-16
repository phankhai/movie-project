package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.Movie;

import java.util.List;

public interface FilmService {

    List<Movie> findAll();
    Movie findById(int id);
    boolean insert(Movie model);
    boolean update(Movie model);
    void delete(int id);
    List<Movie> findMoviePlaying(boolean isplaying);

}
