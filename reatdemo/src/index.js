import React from 'react';
import ReactDOM from 'react-dom';
import './style.css';
import * as serviceWorker from './serviceWorker';
import './icons';
// import App from './app/portals/app.js';
import App from './app/communication/assemblyCommunication/userListContainer'
// ReactDOM.render(<App />, document.getElementById('root'));
ReactDOM.render(<App/>, document.getElementById('root'));
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
