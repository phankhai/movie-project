package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.Cinema_Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface FilmCinemaRepo extends JpaRepository<Cinema_Movie, Integer> {

    @Query(value = "select * from cinemas_movie where cinema_id = :id",
    nativeQuery = true)
    List<Cinema_Movie> findMovieByCinemaId(@Param("id") int id);

    @Modifying
    @Query(value = "insert into cinema_movie (idcinema, idmovie) " +
            "values (:cinema_id, :movie_id)",
    nativeQuery = true)
    @Transactional
    void addMovieCinema(@Param("cinema_id") int idcinema, @Param("movie_id") int idmovie);

    @Query(value = "select * from cinema_movie order by idcinema asc", nativeQuery = true)
    List<Cinema_Movie> findAllCinemaMovie();

}
