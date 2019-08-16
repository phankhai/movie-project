package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.Cinema;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemasRepo extends JpaRepository<Cinema, Integer> {

    //phân trang
    @Query("select c from cinemas c")
    Page<Cinema> findAllPaging(Pageable pageable);

    @Query(value = "select id from cinemas", nativeQuery = true)
    List<Cinema> findAllIdCinema();

    @Query(value = "select * from cinemas where cineplex_id = :id", nativeQuery = true)
    List<Cinema> findCinemaByIdCineplex(@Param("id") int id);

}
