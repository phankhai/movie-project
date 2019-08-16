package com.examplespringboot.demo.Repository;

import com.examplespringboot.demo.Entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepo extends JpaRepository<Room, Integer> {

    public List<Room> findAllByOrderByNameAsc();

    //phân trang
    @Query("select r from rooms r")
    public Page<Room> findAllPaging(Pageable pageable);

}
