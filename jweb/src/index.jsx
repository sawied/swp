import 'babel-polyfill';
import React from 'react';
import ReactDOM from 'react-dom';
import Root from 'components';

// Render the main component into the dom
ReactDOM.render(
  <Root/>
, document.getElementById('app-container'));
