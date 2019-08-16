package com.examplespringboot.demo.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity(name = "movies")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@NotBlank(message = "Tên không để trống")
	private String name;
//	@NotBlank(message = "Vui lòng chọn hình phim")
	private String image;
	@Column(name = "movie_time")
	private int movieTime;
	private String trailer;

	@Column(name = "is_playing")
	private boolean isPlaying;

	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name = "open_date")
//	@Temporal(TemporalType.DATE)
	private Date openDate;
	
	private int ratting;

	@OneToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinColumn(name = "idmovie")
	@OrderBy("idmovie ASC")
	@JsonIgnore
	private Set<Cinema_Movie> cinemaMovies;
	
	public Movie() {
	}

	public Movie(int id, String name, String image, String trailer, String description, Date openDate, int ratting, boolean isPlaying) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.trailer = trailer;
		this.description = description;
		this.openDate = openDate;
		this.ratting = ratting;
		this.isPlaying = isPlaying;
	}

	public int getMovieTime() {
		return movieTime;
	}

	public void setMovieTime(int movieTime) {
		this.movieTime = movieTime;
	}

	public Set<Cinema_Movie> getCinemaMovies() {
		return cinemaMovies;
	}

	public void setCinemaMovies(Set<Cinema_Movie> cinemaMovies) {
		this.cinemaMovies = cinemaMovies;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public int getRatting() {
		return ratting;
	}

	public void setRatting(int ratting) {
		this.ratting = ratting;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean playing) {
		isPlaying = playing;
	}
}
