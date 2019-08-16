package com.examplespringboot.demo.Service;

import com.examplespringboot.demo.Entity.Cineplex;
import com.examplespringboot.demo.Repository.CineplexRepo;
import com.examplespringboot.demo.Service.Impl.CineplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CineplexServiceImp implements CineplexService {

    @Autowired
    private CineplexRepo cineplexRepo;

    @Override
    public List<Cineplex> findAll() {
        return cineplexRepo.findAll();
    }

    @Override
    public Cineplex findById(int id) {
        return cineplexRepo.findById(id).get();
    }

    @Override
    public boolean insert(Cineplex model) {
        cineplexRepo.save(model);
        return true;
    }

    @Override
    public boolean update(Cineplex model) {
        Cineplex update = cineplexRepo.findById(model.getId()).get();
        update.setCinemas(model.getCinemas());
        update.setLogo(model.getLogo());
        update.setName(model.getName());
        if(cineplexRepo.save(update) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean delete(int id) {
        cineplexRepo.deleteById(id);
        return true;
    }
}
