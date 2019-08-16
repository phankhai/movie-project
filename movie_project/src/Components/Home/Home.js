import React, {Component} from 'react';
import SliderBanner from "./SliderBanner";
import SearchBox from "./SearchBox";
import TabMovieSlide from "./TabMovieSlide";
import Slider from "react-slick/lib";
import MoviesShowTime from "./MoviesShowTime";

class Home extends Component {

    render() {
        return (
            <div>
                <SliderBanner />
                <SearchBox />
                <TabMovieSlide />
                <div className="mt-4 mb-4 bannerapp">
                    <img src="./img/bannerapp.png" alt=""/>
                </div>
                <MoviesShowTime />
                <div className="mt-4 mb-4 bannerapp">
                    <img src="./img/bannerapp.png" alt=""/>
                </div>
            </div>
        );
    }
}

export default Home;