package com.examplespringboot.demo.AdminController;

import com.examplespringboot.demo.CustomApi.GetApiCinemaAndMovies;
import com.examplespringboot.demo.CustomApi.GetApiCinemaMovieAndRoom;
import com.examplespringboot.demo.Entity.*;
import com.examplespringboot.demo.Repository.RoomCinemaFilmRepo;
import com.examplespringboot.demo.Service.Impl.*;
import com.examplespringboot.demo.Utils.RestApiContants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ApiController {

    @Autowired
    private FilmService filmService;
    @Autowired
    private CineplexService cineplexService;
    @Autowired
    private CinemaMovieService cinemaMovieService;
    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private RoomCinemaFilmService roomCinemaFilmService;

    @PostMapping(path = "file/upload", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> upload(@RequestParam MultipartFile file) {
        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(RestApiContants.UPLOAD_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println(file.getOriginalFilename());
            return new ResponseEntity<String>(file.getOriginalFilename(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("getMovies/{isplaying}")
    public ResponseEntity<Object> getMovies(@PathVariable boolean isplaying) {
        List<Movie> movies = filmService.findMoviePlaying(isplaying);
        return new ResponseEntity<Object>(movies, HttpStatus.OK);
    }

    @GetMapping("getCineplexAndCinema")
    public ResponseEntity<Object> getCineplexAndCinema() {
        List<Cineplex> cineplexList = cineplexService.findAll();
        List<Cineplex> cineplexes = new ArrayList<>();
        if(cineplexList.size() < 0) {
            ErrorModel errorModel = new ErrorModel(false,"cineplex null");
            return new ResponseEntity<Object>(errorModel,HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Object>(cineplexList,HttpStatus.OK);
    }

    @GetMapping("getCinemaAndMovies")
    public ResponseEntity<Object> getCinemaAndMovies(){
        List<Cinema_Movie> cinema_movies = cinemaMovieService.findAll();
        List<Cinema> cinemas = cinemaService.findAll();
        List<Object> listApi = new ArrayList<>();
        for (Cinema cinema : cinemas){
            for (Cinema_Movie cinema_movie : cinema.getCinemaMovies()){
                GetApiCinemaAndMovies api = new GetApiCinemaAndMovies();
                api.setIdCinemaMovie(cinema_movie.getId());
                api.setIdCinema(cinema.getId());
                api.setNameCinema(cinema_movie.getCinema().getName());
                api.setNameMovie(cinema_movie.getMovie().getName());
                api.setOpenDateMovie(cinema_movie.getMovie().getOpenDate().toString());
                listApi.add(api);
            }
        }
        return new ResponseEntity<Object>(listApi,HttpStatus.OK);
    }

    @GetMapping("getShowtimes")
    public ResponseEntity<Object> getShowtimes() {
        List<CinemaMovie_Room> cinemaMovie_rooms = roomCinemaFilmService.findAll();
        List<Object> apilist = new ArrayList<>();
        for (CinemaMovie_Room cinemaMovie_room : cinemaMovie_rooms){
            for (Showtime showtime : cinemaMovie_room.getShowtimes()){
                GetApiCinemaMovieAndRoom api = new GetApiCinemaMovieAndRoom();
                api.setIdCinemaMovie(cinemaMovie_room.getCinema_movie().getId());
                api.setOpenHoursMovie(showtime.getOpenHours().toString());
                api.setIdRoom(showtime.getCinemaMovie_room().getRoom().getId());
                apilist.add(api);
            }
        }
        return new ResponseEntity<Object>(apilist,HttpStatus.OK);
    }

//    @GetMapping("getShowtimeByIdMovie")


}
