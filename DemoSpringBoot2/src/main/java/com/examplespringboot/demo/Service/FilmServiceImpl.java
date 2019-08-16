package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.Movie;
import com.examplespringboot.demo.Repository.FilmRepo;
import com.examplespringboot.demo.Service.Impl.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmServiceImpl implements FilmService {

    @Autowired
    private FilmRepo filmRepo;

    @Override
    public List<Movie> findAll() {
        return filmRepo.findAll();
    }

    @Override
    public Movie findById(int id) {
        return filmRepo.findById(id).get();
    }

    @Override
    public boolean insert(Movie model) {
        filmRepo.save(model);
        return true;
    }

    @Override
    public boolean update(Movie model) {
        Movie movieupdate = filmRepo.findById(model.getId()).get();
        movieupdate.setName(model.getName());
        movieupdate.setDescription(model.getDescription());
        movieupdate.setOpenDate(model.getOpenDate());
        movieupdate.setRatting(model.getRatting());
        movieupdate.setTrailer(model.getTrailer());
        movieupdate.setImage(model.getImage());
        filmRepo.save(movieupdate);
        return true;
    }

    @Override
    public void delete(int id) {
        filmRepo.deleteById(id);
    }

    @Override
    public List<Movie> findMoviePlaying(boolean isplaying) {
        return filmRepo.findMoviePlaying(isplaying);
    }






}
