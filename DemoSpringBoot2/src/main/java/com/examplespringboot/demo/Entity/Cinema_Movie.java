package com.examplespringboot.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.annotation.Order;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cinema_movie")
public class Cinema_Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "idmovie")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "idcinema")
    @OrderBy("idcinema ASC")
    private Cinema cinema;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "idcinema_movie")
    @JsonIgnore
    Set<CinemaMovie_Room> cinemaMovie_rooms;

    public Set<CinemaMovie_Room> getCinemaMovie_rooms() {
        return cinemaMovie_rooms;
    }

    public void setCinemaMovie_rooms(Set<CinemaMovie_Room> cinemaMovie_rooms) {
        this.cinemaMovie_rooms = cinemaMovie_rooms;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
