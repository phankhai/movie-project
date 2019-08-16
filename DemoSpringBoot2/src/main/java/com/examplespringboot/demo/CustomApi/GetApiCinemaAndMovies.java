package com.examplespringboot.demo.CustomApi;

public class GetApiCinemaAndMovies {

    private int idCinemaMovie;
    private int idCinema;
    private String nameCinema;
    private String nameMovie;
    private String openDateMovie;

    public int getIdCinemaMovie() {
        return idCinemaMovie;
    }

    public void setIdCinemaMovie(int idCinemaMovie) {
        this.idCinemaMovie = idCinemaMovie;
    }

    public String getNameCinema() {
        return nameCinema;
    }

    public void setNameCinema(String nameCinema) {
        this.nameCinema = nameCinema;
    }

    public int getIdCinema() {
        return idCinema;
    }

    public void setIdCinema(int idCinema) {
        this.idCinema = idCinema;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public String getOpenDateMovie() {
        return openDateMovie;
    }

    public void setOpenDateMovie(String openDateMovie) {
        this.openDateMovie = openDateMovie;
    }
}
