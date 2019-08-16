package com.examplespringboot.demo.Service.Impl;


import com.examplespringboot.demo.Entity.Cinema_Movie;

import java.util.List;

public interface CinemaMovieService {

    public List<Cinema_Movie> findAll();
    public List<Cinema_Movie> findMovieByCinemaId(int id);
    public boolean addMovieCinema(List<Integer> idcinema, List<Integer> idmovie);
}
