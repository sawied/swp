
require('styles/jweb.scss');

import React from 'react';
import {Provider} from 'react-redux';

import UserProfile from './userProfile';
import Navigation from './navigation';
import ErrorPanel from './errorPanel';

import Home from './Home';
import imager from '../imager';
import TodoApp from '../todos';
import {
  BrowserRouter,
  Route,
  Switch
} from 'react-router-dom';
import configureStore from './../store/configureStore';


//create store
let store = configureStore();
const jwebRoot=()=>(
  <Provider store={store}>
  <BrowserRouter>
<div id="app-root">
<div className="header">
</div>
<div id="app-body">
<div className="left-panel">
<UserProfile/>
<Navigation/>
</div>
<div className="right-panel">
<Switch>
        <Route exact path='/' component={Home} />
        <Route path="/todoApp" component={TodoApp}/>
        <Route path='/imager' component={imager}/>
  </Switch>
</div>
</div>
<div className="footer"></div>
<ErrorPanel/>
</div>
</BrowserRouter>
</Provider>
)


export default jwebRoot;