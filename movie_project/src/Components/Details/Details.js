import React, {Component} from 'react';
import {Tab, Row, Col, Nav} from "react-bootstrap";
import {connect} from "react-redux";

class Details extends Component {

    constructor(props){
        super(props);
        this.state = {
            cineplexcinema : JSON.parse(localStorage.getItem("cineplex-cinema")),
            cinemamovies : JSON.parse(localStorage.getItem("cinema-movie")),
            showtimes: JSON.parse(localStorage.getItem("showtimes")),
            movieplaying : JSON.parse(localStorage.getItem("movie-playing")),
        }
    }

    API_URL = "http://localhost:8080";

    render() {
        const {cineplexcinema, cinemamovies, showtimes,movieplaying} = this.state;
        const params = this.props.match.params;
        const firstIdCinema = cineplexcinema[0].id;
        return (
            <div>
                <div className="backgroundMain">
                    <div className="detailMainInfo">
                        {
                            movieplaying.map((val,key) => {
                                if(val.id == params.id){
                                    return(
                                        <div className="row" key={key}>
                                            <div className="col-md-3">
                                                <img src={this.API_URL+val.image} alt="" height="306"/>
                                            </div>
                                            <div className="col-md-5">
                                                <div className="movie-name">
                                                    <span>{val.openDate}</span>
                                                    <strong>{val.name}</strong>
                                                    <span>{val.movieTime} Giờ - 0 IMDb - 2D/Digital</span>
                                                </div>
                                            </div>
                                            <div className="col-sm-2 offset-1">{val.ratting}</div>
                                        </div>
                                    )
                                }
                            })
                        }
                    </div>
                </div>
                <div className="mainContent">
                    <ul className="nav nav-tabs">
                        <li className="nav-item">
                            <a className="nav-link active" data-toggle="tab" href="#page-details">Lịch Chiếu</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" data-toggle="tab" href="#menu1">Thông Tin</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" data-toggle="tab" href="#menu2">Đánh Giá</a>
                        </li>
                    </ul>
                    <div className="tab-content mt-5">
                        <div className="tab-pane container active" id="page-details">
                            <Tab.Container id="left-tabs-example" defaultActiveKey={"tab"+firstIdCinema}>
                                <Row>
                                    <Col sm={{span:3,offset:1}}>
                                        <Nav variant="pills" className="flex-column">
                                            {
                                                cineplexcinema.map((val,key) => {
                                                    return (
                                                        <span key={key}>
                                                            <Nav.Item className="item-logo mb-3">
                                                                <Nav.Link eventKey={"tab"+val.id}>
                                                                    <img src={this.API_URL+val.logo} alt=""/>
                                                                    <strong className="ml-4">{val.name}</strong>
                                                                </Nav.Link>
                                                            </Nav.Item>
                                                            <hr/>
                                                        </span>
                                                    )
                                                })
                                            }
                                        </Nav>
                                    </Col>
                                    <Col sm={8}>
                                        <Tab.Content className="detail-movie">
                                            {
                                                cineplexcinema.map((val,key) => {
                                                    return (
                                                        <Tab.Pane eventKey={"tab"+val.id} key={key}>
                                                            <div className="row">
                                                                {
                                                                    val.cinemas.map((cinema,key) => {
                                                                        return (
                                                                            <div className="col-sm-12" key={key}>
                                                                                <div className="row detail-cinema">
                                                                                    <div className="col-2">
                                                                                        <img src={this.API_URL+cinema.image} alt="hinhrap"/>
                                                                                    </div>
                                                                                    <div className="col-10">
                                                                                        <p className="mb-0">{cinema.name}</p>
                                                                                        <p>{cinema.address}</p>
                                                                                        <span className="check-showtime">
                                                                                    {

                                                                                    }
                                                                                    </span>
                                                                                    </div>
                                                                                </div>
                                                                                <hr/>
                                                                            </div>
                                                                        )
                                                                    })
                                                                }
                                                            </div>
                                                        </Tab.Pane>
                                                    )
                                                })
                                            }
                                        </Tab.Content>
                                    </Col>
                                </Row>
                            </Tab.Container>
                        </div>
                        <div className="tab-pane container fade" id="menu1">
                            <div className="row">
                                <div className="col-sm-6">
                                    <div className="row">
                                        <div className="col-4">Địa Điểm</div>
                                        <div className="col-8">L3-Bitexco Icon 68, 2 Hải Triều, Q.1</div>
                                        <div className="col-4">Địa Điểm</div>
                                        <div className="col-8">L3-Bitexco Icon 68, 2 Hải Triều, Q.1</div>
                                        <div className="col-4">Địa Điểm</div>
                                        <div className="col-8">L3-Bitexco Icon 68, 2 Hải Triều, Q.1</div>
                                        <div className="col-4">Địa Điểm</div>
                                        <div className="col-8">L3-Bitexco Icon 68, 2 Hải Triều, Q.1</div>
                                        <div className="col-4">Địa Điểm</div>
                                        <div className="col-8">L3-Bitexco Icon 68, 2 Hải Triều, Q.1</div>
                                    </div>
                                </div>
                                <div className="col-sm-6">
                                    <div className="row">
                                        <div className="col-sm-12">Giới Thiệu</div>
                                        <div className="col-sm-12">
                                            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium aut beatae delectus dignissimos doloremque dolorum esse fugit ipsum maiores non odio praesentium, qui similique sit tenetur. Adipisci dolores harum voluptatem?
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="tab-pane container fade" id="menu2">Đánh Giá</div>
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
        getAll : () => {
            dispatch({type : "GET_ALL"})
        }
    }
}
export default connect(mapStateToProps,mapDispatchToProps) (Details);