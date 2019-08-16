package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.Service.Impl.CinemaMovieService;
import com.examplespringboot.demo.Service.Impl.CinemaService;
import com.examplespringboot.demo.Service.Impl.CineplexService;
import com.examplespringboot.demo.Service.Impl.FilmService;
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
@RequestMapping("admin/filmcinema")
public class CinemaMovieController {

    @Autowired
    private CinemaMovieService cinemaMovieService;
    @Autowired
    private FilmService filmService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private CineplexService cineplexService;

    @GetMapping
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("films", filmService.findAll());
        return "admin/cinema-movie";
    }

    @GetMapping("add")
    public String addPage(ModelMap modelMap){
        modelMap.addAttribute("films",filmService.findAll());
        modelMap.addAttribute("cinemas",cinemaService.findAll());
        return "admin/cinema-movie-add";
    }

    @PostMapping("add")
    public ResponseEntity<Object> addData(@RequestParam("checkphim[]")List<Integer> checkphim,
                                          @RequestParam("checkrap[]")List<Integer> checkrap) {
        boolean checkAdd = cinemaMovieService.addMovieCinema(checkrap, checkphim);
        if (checkAdd) {
            return new ResponseEntity<Object>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(false, HttpStatus.OK);
        }
    }





}
