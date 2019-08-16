package com.examplespringboot.demo.Service;


import com.examplespringboot.demo.Entity.Cinema_Movie;
import com.examplespringboot.demo.Repository.FilmCinemaRepo;
import com.examplespringboot.demo.Service.Impl.CinemaMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaMovieServiceImpl implements CinemaMovieService {

    @Autowired
    private FilmCinemaRepo filmCinemaRepo;

    @Override
    public List<Cinema_Movie> findAll() {
        return filmCinemaRepo.findAll();
    }

    @Override
    public List<Cinema_Movie> findMovieByCinemaId(int id) {
        return filmCinemaRepo.findMovieByCinemaId(id);
    }

    @Override
    public boolean addMovieCinema(List<Integer> idcinemas, List<Integer> idmovies) {
        try{
            for (Integer idcinema : idcinemas){
                for (Integer idmovie : idmovies){
                    filmCinemaRepo.addMovieCinema(idcinema, idmovie);
                }
            }
            return true;
        } catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }
}
