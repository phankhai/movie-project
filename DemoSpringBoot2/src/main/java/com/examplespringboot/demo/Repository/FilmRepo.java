package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepo extends JpaRepository<Movie, Integer> {

    @Query(value = "select m from movies m where m.isPlaying = :isPlaying", nativeQuery = false)
    List<Movie> findMoviePlaying(@Param("isPlaying") boolean isplaying);

    List<Movie> findFirstById(int id);


}
