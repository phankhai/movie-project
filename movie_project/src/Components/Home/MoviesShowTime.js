import React, {Component} from 'react';
import {connect} from "react-redux";
import axios from "axios";
import {Tab, Row, Col, Nav} from "react-bootstrap";

class MoviesShowTime extends Component {
    constructor(props){
        super(props);
        this.state = {
        }
    }

    API_URL = "http://localhost:8080";

    componentWillMount() {
        axios({
            method : 'get',
            url : `${this.API_URL}/api/getCineplexAndCinema`,
            data : null,
        }).then(res => {
            this.props.getCineplexCinema(res.data);
            localStorage.setItem("cineplex-cinema",JSON.stringify(res.data));
        })
        axios({
            method : 'get',
            url : `${this.API_URL}/api/getCinemaAndMovies`,
            data : null,
        }).then(res => {
            this.props.getCinemaMovie(res.data);
            localStorage.setItem("cinema-movie",JSON.stringify(res.data));
        })
        axios({
            method : 'get',
            url : `${this.API_URL}/api/getShowtimes`,
            data : null,
        }).then(res => {
            this.props.showtimeMovies(res.data);
            localStorage.setItem("showtimes",JSON.stringify(res.data));
        })
    }

    render() {
        const {movies} = this.props;
        // console.log(movies);
        return (
            <div id="movies-showtime">
                <Tab.Container id="left-tabs-example" defaultActiveKey="Tab0">
                    <Row>
                        <Col sm={1}>
                            <Nav variant="pills" className="flex-column">
                                {
                                    movies.cineplexsAndcinema.map((val, key) => {
                                        return (
                                            <span key={key}>
                                                <Nav.Item className="item-logo mb-3">
                                                    <Nav.Link eventKey={"Tab"+key}>
                                                        <img src={'http://localhost:8080'+val.logo} alt=""/>
                                                    </Nav.Link>
                                                </Nav.Item>
                                                <hr/>
                                            </span>
                                        )
                                    })
                                }
                            </Nav>
                        </Col>
                        <Col sm={11}>
                            <Tab.Content>
                                {
                                    movies.cineplexsAndcinema.map((val,key) => {
                                        return (
                                            <Tab.Pane eventKey={"Tab"+key} key={key}>
                                                <Tab.Container id="left-tabs-example" defaultActiveKey="Tab0">
                                                    <Row>
                                                        <Col sm={5}>
                                                            <Nav variant="pills" className="flex-column">
                                                                {
                                                                    val.cinemas.map((val,key) => {
                                                                        return (
                                                                            <Nav.Item key={key} className="ml-3 item-cinema">
                                                                                <Nav.Link eventKey={"Tab"+key}>
                                                                                    <img src={this.API_URL+val.image} alt=""/>
                                                                                    <p>{val.name}</p>
                                                                                    <p>{val.address}</p>
                                                                                    <hr />
                                                                                </Nav.Link>
                                                                            </Nav.Item>
                                                                        )
                                                                    })
                                                                }
                                                            </Nav>
                                                        </Col>
                                                        <Col sm={7}>
                                                            <Tab.Content>
                                                                {
                                                                    val.cinemas.map((cinema,key) => {
                                                                        return (
                                                                            <Tab.Pane eventKey={"Tab"+key} key={key}>
                                                                                {
                                                                                    movies.cinemaAndmovie.map((cinemamovie,key)=> {
                                                                                        if(cinemamovie.idCinema == cinema.id) {
                                                                                            return (
                                                                                                <div key={key} className="mb-4 showtime">
                                                                                                    <h6>{cinemamovie.nameMovie}</h6>
                                                                                                    {
                                                                                                        movies.showtimes.map((showtime, key) => {
                                                                                                            if(showtime.idCinemaMovie == cinemamovie.idCinemaMovie){
                                                                                                                return(
                                                                                                                    <span key={key} className="mt-2 mr-3">
                                                                                                                        {showtime.openHoursMovie}
                                                                                                                    </span>
                                                                                                                )
                                                                                                            }
                                                                                                        })
                                                                                                    }
                                                                                                    <hr />
                                                                                                </div>
                                                                                            );
                                                                                        }
                                                                                    })
                                                                                }
                                                                            </Tab.Pane>
                                                                        )
                                                                    })
                                                                }
                                                            </Tab.Content>
                                                        </Col>
                                                    </Row>
                                                </Tab.Container>
                                            </Tab.Pane>
                                        )
                                    })
                                }
                            </Tab.Content>
                        </Col>
                    </Row>
                </Tab.Container>
            </div>
        );
    }
}
const mapStateToProps = (state) => {
    return {
        movies: state.movies
    }
}

const mapDispatchToProps = (dispatch, props) => {
    return {
        getCineplexCinema : (cineplexs) => {
            dispatch({type : "GET_CINEPLEX_CINEMA", cineplexs});
        },
        getCinemaMovie : (cinemas) => {
            dispatch({type : "GET_CINEMA_MOVIE", cinemas});
        },
        showtimeMovies : (showtimes) => {
            dispatch({type : "GET_SHOWTIME_MOVIE", showtimes});
        },
    }
}
export default connect(mapStateToProps,mapDispatchToProps)(MoviesShowTime);