import React, {Component} from 'react';
import Slider from 'react-slick/lib';
import {connect} from "react-redux";
import axios from "axios";
import {Link} from "react-router-dom";
import FormatSlug from "../FormatSlug";

class TabMovieSlide extends Component {
    constructor(props){
        super(props);
        this.state = {
            statustab : []
        }
    }
    API_URL = "http://localhost:8080";

    componentWillMount() {
        axios({
            method : 'get',
            url : `${this.API_URL}/api/getMovies/true`,
            data : null,
        }).then(res => {
            this.props.getMoviesDangChieu(res.data);
            localStorage.setItem("movie-playing",JSON.stringify(res.data));
        }).catch(function (error) {
            console.log(error.response);
        });

        axios({
            method : 'get',
            url : `${this.API_URL}/api/getMovies/false`,
            data : null,
        }).then(res => {
            this.props.getMoviesSapChieu(res.data);
        }).catch(function (error) {
            console.log(error.response);
        });
    }

    next = () => {
        this.slider.slickNext();
    }

    prev = () => {
        this.slider.slickPrev();
    }

    render() {
        const {movies} = this.props;
        // console.log(movies);
        const settings_phimdangchieu= {
            infinite: true,
            slidesToShow: 1,
            speed: 500,
            rows: 2,
            slidesPerRow: 4
        };
        return (
            <div id="tabmovie-slide">
                <ul className="nav nav-tabs">
                    <li className="nav-item">
                        <a className="nav-link active" data-toggle="tab" href="#home">Đang Chiếu</a>
                    </li>
                    <li className="nav-item">
                        <a className="nav-link" data-toggle="tab" href="#menu1">Sắp Chiếu</a>
                    </li>
                </ul>
                <div className="tab-content">
                    <div className="tab-pane container active" id="home">
                        <Slider ref={c => (this.slider = c)} {...settings_phimdangchieu}>
                            {
                                movies.phimdangchieu.map((val,key) => (
                                    <div key={key}>
                                        <div className="card mt-3">
                                            <img className="movie-img"
                                                 src={this.API_URL+val.image}
                                                 alt="" />
                                            <div className="display-play">
                                                <a href="#" data-video-id={val.trailer} className="btn-play">
                                                    <img src="./modal-video/play-video.png"
                                                         alt="" />
                                                    <p>TRAILER</p>
                                                </a>
                                                <div className="animation_movie"></div>
                                            </div>
                                            <div className="card-body">
                                                <h4 className="card-title name-movie"><strong>{val.name}</strong></h4>
                                                <span className="openDate">{val.ratting}*</span>
                                                <Link to={`/details-${val.id}-${FormatSlug(val.name)}.html`}
                                                      className="btn btn-sm btn-outline-danger btn-block">
                                                    Mua Vé
                                                </Link>
                                            </div>
                                        </div>
                                    </div>
                                ))
                            }
                        </Slider>
                        <i className="fas fa-chevron-left" onClick={this.prev}></i>
                        <i className="fas fa-chevron-right" onClick={this.next}></i>
                    </div>
                    <div className="tab-pane container fade" id="menu1">
                        <Slider {...settings_phimdangchieu}>
                            {
                                movies.phimsapchieu.map((val,key) => (
                                    <div key={key}>
                                        <div className="card mt-3">
                                            <img className="movie-img"
                                                 src={this.API_URL+val.image}
                                                 alt="" />
                                            <div className="display-play">
                                                <a href="#" data-video-id={val.trailer} className="btn-play">
                                                    <img src="./modal-video/play-video.png"
                                                         alt="" />
                                                    <p>TRAILER</p>
                                                </a>
                                                <div className="animation_movie"></div>
                                            </div>
                                            <div className="card-body">
                                                <h4 className="card-title name-movie"><strong>{val.name}</strong></h4>
                                                <button className="btn btn-md btn-outline-danger btn-block">Mua Vé</button>
                                            </div>
                                        </div>
                                    </div>
                                ))
                            }
                        </Slider>
                        <i className="fas fa-chevron-left" onClick={this.prev}></i>
                        <i className="fas fa-chevron-right" onClick={this.next}></i>
                    </div>
                </div>
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
        getMoviesDangChieu : (phimdangchieu) => {
            dispatch({type: "GET_MOVIES_DANGCHIEU", phimdangchieu})
        },
        getMoviesSapChieu : (phimsapchieu) => {
            dispatch({type: "GET_MOVIES_SAPCHIEU", phimsapchieu})
        }
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(TabMovieSlide);

