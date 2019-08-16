import React, {Component} from 'react';
import './App.css';
import Header from "./Components/Header";
import Home from "./Components/Home/Home";
import DieuHuong from "./Components/Route/DieuHuong";

class App extends Component {
  render() {
    return (
        <div>
            <Header />
            <DieuHuong />
        </div>
    );
  }
}

export default App;
