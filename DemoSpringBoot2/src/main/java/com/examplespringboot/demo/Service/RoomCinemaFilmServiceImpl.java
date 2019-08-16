package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.CinemaMovie_Room;
import com.examplespringboot.demo.Entity.ErrorModel;
import com.examplespringboot.demo.Repository.RoomCinemaFilmRepo;
import com.examplespringboot.demo.Service.Impl.RoomCinemaFilmService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomCinemaFilmServiceImpl implements RoomCinemaFilmService {

    @Autowired
    private RoomCinemaFilmRepo roomCinemaFilmRepo;

    @Override
    public List<CinemaMovie_Room> findAll() {
        return roomCinemaFilmRepo.findAll();
    }

    @Override
    public CinemaMovie_Room findById(int id) {
        return roomCinemaFilmRepo.findById(id).get();
    }

    @Override
    public boolean insert(CinemaMovie_Room model) {
        return false;
    }

    @Override
    public boolean update(CinemaMovie_Room model) {
        return false;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public boolean insertRoomAndMovie(List<Integer> idcinemamovies, List<Integer> idrooms) {
        try{
            for (Integer idcinemamovie : idcinemamovies){
                for (Integer idroom : idrooms){
                    roomCinemaFilmRepo.insertCinemaMovieRoom(idcinemamovie, idroom);
                }
            }
            return true;
        } catch (RuntimeException e){
            e.printStackTrace();
            return false;
        }
    }


}
