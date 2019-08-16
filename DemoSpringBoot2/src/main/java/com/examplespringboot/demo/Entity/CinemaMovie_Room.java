package com.examplespringboot.demo.Entity;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cinemamovie_room")
public class CinemaMovie_Room {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "idcinema_movie")
    private Cinema_Movie cinema_movie;

    @OneToOne
    @JoinColumn(name = "idroom")
    private Room room;

    @OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
    @JoinColumn(name = "idcinemamovie_room")
    private Set<Showtime> showtimes;

    public Set<Showtime> getShowtimes() {
        return showtimes;
    }

    public void setShowtimes(Set<Showtime> showtimes) {
        this.showtimes = showtimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cinema_Movie getCinema_movie() {
        return cinema_movie;
    }

    public void setCinema_movie(Cinema_Movie cinema_movie) {
        this.cinema_movie = cinema_movie;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
