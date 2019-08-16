package com.examplespringboot.demo.CustomApi;

import java.util.Set;

public class GetApiCinemaMovieAndRoom {

    private int idCinemaMovie;
    private int idCinemaMovieRoom;
    private String openHoursMovie;
    private int movieTime;
    private int idRoom;

    public int getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(int movieTime) {
        this.movieTime = movieTime;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getOpenHoursMovie() {
        return openHoursMovie;
    }

    public void setOpenHoursMovie(String openHoursMovie) {
        this.openHoursMovie = openHoursMovie;
    }

    public int getIdCinemaMovie() {
        return idCinemaMovie;
    }

    public void setIdCinemaMovie(int idCinemaMovie) {
        this.idCinemaMovie = idCinemaMovie;
    }

    public int getIdCinemaMovieRoom() {
        return idCinemaMovieRoom;
    }

    public void setIdCinemaMovieRoom(int idCinemaMovieRoom) {
        this.idCinemaMovieRoom = idCinemaMovieRoom;
    }
}
