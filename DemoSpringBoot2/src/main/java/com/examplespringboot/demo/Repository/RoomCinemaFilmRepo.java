package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.CinemaMovie_Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RoomCinemaFilmRepo extends JpaRepository<CinemaMovie_Room, Integer> {

    @Modifying
    @Query(value = "insert into cinemamovie_room(idcinema_movie, idroom) values (:idcinema, :idroom)", nativeQuery = true)
    @Transactional
    void insertCinemaMovieRoom(@Param("idcinema") int idcinemamovie, @Param("idroom") int idroom);


}
