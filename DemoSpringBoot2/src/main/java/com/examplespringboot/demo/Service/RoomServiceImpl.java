package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.Room;
import com.examplespringboot.demo.Repository.RoomRepo;
import com.examplespringboot.demo.Service.Impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Override
    public List<Room> findAll() {
        return roomRepo.findAll();
    }

    @Override
    public Room findById(int id) {
        return roomRepo.findById(id).get();
    }

    @Override
    public boolean insert(Room model) {
        roomRepo.save(model);
        return true;
    }

    @Override
    public boolean update(Room model) {
        Room roomupdate = roomRepo.findById(model.getId()).get();
        roomupdate.setName(model.getName());
        roomRepo.save(roomupdate);
        return true;
    }

    @Override
    public void delete(int id) {
        roomRepo.deleteById(id);
    }

    @Override
    public List<Room> findAllByOrderByNameAsc() {
        return roomRepo.findAllByOrderByNameAsc();
    }

    @Override
    public Page<Room> findAllPage(int pageIndex, int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        return roomRepo.findAllPaging(pageable);
    }

}
