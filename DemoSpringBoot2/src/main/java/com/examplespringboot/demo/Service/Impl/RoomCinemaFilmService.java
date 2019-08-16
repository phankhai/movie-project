package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.CinemaMovie_Room;
import com.examplespringboot.demo.Entity.ErrorModel;

import java.util.List;

public interface RoomCinemaFilmService {

    List<CinemaMovie_Room> findAll();
    CinemaMovie_Room findById(int id);
    boolean insert(CinemaMovie_Room model);
    boolean update(CinemaMovie_Room model);
    void delete(int id);

    boolean insertRoomAndMovie(List<Integer> idcinemamovies, List<Integer> idrooms);

}
