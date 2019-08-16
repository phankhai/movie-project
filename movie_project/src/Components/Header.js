import React, {Component} from 'react';
import {Link} from "react-router-dom";

class Header extends Component {
    render() {
        return (
            <header>
                <nav className="navbar navbar-expand-sm navbar-light bg-light fixed-top border-bottom">
                    <Link to={`/`} className="navbar-brand" href="#">
                        <img src="./img/logo.png" height="50" alt="logo" />
                    </Link>
                    <ul className="navbar-nav m-auto">
                        <li className="nav-item">
                            <a className="nav-link" href="#" id="lichchieu">Lịch chiếu</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Cụm rạp</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Tin tức</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" href="#">Liên hệ</a>
                        </li>
                    </ul>
                    <div>
                        <div id="client-login">
                            <ul className="navbar-nav">
                                <button className="btn btn-sm btn-outline-primary mr-2" data-toggle="modal"
                                        data-target="#loginModal">Đăng nhập
                                </button>
                                <button className="btn btn-sm btn-outline-danger" data-toggle="modal"
                                        data-target="#registerModal">
                                    Đăng ký
                                </button>
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
        );
    }
}

export default Header;