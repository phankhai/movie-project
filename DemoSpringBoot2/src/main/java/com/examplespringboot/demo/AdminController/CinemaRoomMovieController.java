package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Entity.Cinema;
import com.examplespringboot.demo.Entity.Cinema_Movie;
import com.examplespringboot.demo.Entity.ErrorModel;
import com.examplespringboot.demo.Repository.FilmCinemaRepo;
import com.examplespringboot.demo.Service.Impl.CinemaMovieService;
import com.examplespringboot.demo.Service.Impl.CinemaService;
import com.examplespringboot.demo.Service.Impl.RoomCinemaFilmService;
import com.examplespringboot.demo.Service.Impl.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("admin/roomcinema")
public class CinemaRoomMovieController {

    @Autowired
    private CinemaMovieService cinemaMovieService;
    @Autowired
    private RoomCinemaFilmService roomCinemaFilmService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private RoomService roomService;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("cinemas",cinemaService.findAll());
        modelMap.addAttribute("cinemamovie",cinemaMovieService.findAll());
        return "admin/cinema-room-movie";
    }

    @Autowired
    private FilmCinemaRepo filmCinemaRepo;
    @GetMapping("add")
    public String addPage(ModelMap modelMap){
        modelMap.addAttribute("cinemas", cinemaService.findAll());
        modelMap.addAttribute("rooms", roomService.findAll());
        modelMap.addAttribute("cinemamovies",filmCinemaRepo.findAllCinemaMovie());
        return "admin/cinema-room-movie-add";
    }

    @PostMapping("add")
    public ResponseEntity<String> addData(@RequestParam("checkphim[]")List<Integer> checkphim,
                                  @RequestParam("checkphong[]")List<Integer> checkphong) {
        boolean roomAdd = roomCinemaFilmService.insertRoomAndMovie(checkphim, checkphong);
        if(roomAdd){
            return new ResponseEntity<String>("true", HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("false", HttpStatus.OK);
        }
    }


}
