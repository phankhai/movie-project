import React, {Component} from 'react';
import Slider from 'react-slick/lib';

class SliderBanner extends Component {

    render() {
        const settings = {
            dots: true,
            infinite: true,
            slidesToShow: 1,
            slidesToScroll: 1,
            autoplay: true,
            autoplaySpeed: 3000,
            cssEase: "linear"
        };

        return (
            <div className="sliderbanner">
                <Slider {...settings}>
                    <div className="movie-banner">
                        <img className="w-100"
                             src="https://s3img.vcdn.vn/123phim/2019/06/bhd-69k-15609294042765.jpg"
                             alt="" />
                        <div className="display-play">
                            <a href="#" data-video-id="2H-1e4XNLBo" className="btn-play">
                                <img src="./img/play-video.png"
                                     alt="" />
                            </a>
                        </div>
                    </div>
                    <div className="movie-banner">
                        <img className="w-100"
                             src="https://s3img.vcdn.vn/123phim/2019/06/bhd-69k-15609294042765.jpg"
                             alt="" />
                        <div className="display-play">
                            <a href="#" data-video-id="2H-1e4XNLBo" className="btn-play">
                                <img src="./img/play-video.png"
                                     alt="" />
                            </a>
                        </div>
                    </div>
                    <div className="movie-banner">
                        <img className="w-100"
                             src="https://s3img.vcdn.vn/123phim/2019/06/bhd-69k-15609294042765.jpg"
                             alt="" />
                        <div className="display-play">
                            <a href="#" data-video-id="2H-1e4XNLBo" className="btn-play">
                                <img src="./img/play-video.png"
                                     alt="" />
                            </a>
                        </div>
                    </div>
                </Slider>
            </div>
        );
    }
}

export default SliderBanner;