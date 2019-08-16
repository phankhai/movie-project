package com.examplespringboot.demo.Service.Impl;

import com.examplespringboot.demo.Entity.Room;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoomService {

    List<Room> findAll();
    Room findById(int id);
    List<Room> findAllByOrderByNameAsc();
    boolean insert(Room model);
    boolean update(Room model);
    void delete(int id);

    Page<Room> findAllPage(int pageIndex, int pageSize);
}
