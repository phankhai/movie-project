import axios from "axios";

var initialMovies = {
    phimdangchieu : [],
    phimsapchieu: [],
    cineplexsAndcinema: [],
    cinemaAndmovie: [],
    showtimes: []
};

var Movies = (state = initialMovies, action) => {
    switch (action.type) {
        case "GET_ALL":
            return state;
        case "GET_MOVIES_DANGCHIEU":
            return {...state, phimdangchieu: action.phimdangchieu}
        case "GET_MOVIES_SAPCHIEU":
            return {...state, phimsapchieu: action.phimsapchieu}
        case "GET_CINEPLEX_CINEMA" :
            return {...state, cineplexsAndcinema : action.cineplexs};
        case "GET_CINEMA_MOVIE" :
            return {...state, cinemaAndmovie : action.cinemas};
        case "GET_SHOWTIME_MOVIE" :
            return {...state, showtimes : action.showtimes};
        default :
            return state;
    }
}

export default Movies;