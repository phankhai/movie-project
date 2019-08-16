package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.Cinema;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CinemaService {

    List<Cinema> findAll();
    Cinema findById(int id);
    boolean insert(Cinema model);
    boolean update(Cinema model);
    void delete(int id);

    Page<Cinema> findAllPaging(int pageIndex, int pageSize);
    List<Cinema> findAllIdCinema();
    List<Cinema> findCinemaByIdCineplex(int id);
}
