package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.Cinema;
import com.examplespringboot.demo.Repository.CinemasRepo;
import com.examplespringboot.demo.Service.Impl.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemasRepo cinemasRepo;

    @Override
    public List<Cinema> findAll() {
        return cinemasRepo.findAll();
    }

    @Override
    public Cinema findById(int id) {
        return cinemasRepo.findById(id).get();
    }

    @Override
    public boolean insert(Cinema model) {
        cinemasRepo.save(model);
        return true;
    }

    @Override
    public boolean update(Cinema model) {
        Cinema cinemaUpdate = cinemasRepo.findById(model.getId()).get();
        cinemaUpdate.setAddress(model.getAddress());
        cinemaUpdate.setCineplexId(model.getCineplexId());
        cinemaUpdate.setDescription(model.getDescription());
        cinemaUpdate.setImage(model.getImage());
        cinemaUpdate.setName(model.getName());
        cinemaUpdate.setPhone(model.getPhone());
        cinemasRepo.save(cinemaUpdate);
        return true;
    }

    @Override
    public void delete(int id) {
        cinemasRepo.deleteById(id);
    }

    @Override
    public Page<Cinema> findAllPaging(int pageIndex, int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        return cinemasRepo.findAllPaging(pageable);
    }

    @Override
    public List<Cinema> findAllIdCinema() {
        return cinemasRepo.findAllIdCinema();
    }

    @Override
    public List<Cinema> findCinemaByIdCineplex(int id) {
        return cinemasRepo.findCinemaByIdCineplex(id);
    }
}
