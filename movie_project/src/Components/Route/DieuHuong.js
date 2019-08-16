import React, {Component} from 'react';
import Home from "../Home/Home";
import { BrowserRouter as Router, Route, Link, Switch, Redirect } from "react-router-dom";
import Details from "../Details/Details";

class DieuHuong extends Component {
    render() {
        return(
            <Switch>
                <Route exact path="/" component={Home} />
                <Route path="/details-:id-:name.html" component={Details} />
            </Switch>
        );
    }
}

export default DieuHuong;