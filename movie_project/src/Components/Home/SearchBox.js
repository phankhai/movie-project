import React, {Component} from 'react';

class SearchBox extends Component {
    render() {
        return (
            <div id="search-box">
                <div className="container">
                    <div className="row">
                        <div className="col-sm">
                            <select className="form-control" id="sel1" name="sellist1">
                                <option>Phim</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <div className="col-sm">
                            <select className="form-control" id="sel1" name="sellist1">
                                <option>Rạp</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <div className="col-sm">
                            <select className="form-control" id="sel1" name="sellist1">
                                <option>Ngày Chiếu</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <div className="col-sm">
                            <select className="form-control" id="sel1" name="sellist1">
                                <option>Xuất Chiếu</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                            </select>
                        </div>
                        <div className="col-sm">
                            <button type="button" className="btn btn-outline-danger">Tìm Kiếm</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default SearchBox;