
import React from 'react';
import {Provider} from 'react-redux';
import Layout from './layout';
import Home from './Home';
import Uploader from './uploader';
import TodoApp from '../todos';
import {Router,Route,browserHistory,IndexRoute} from 'react-router';
import configureStore from './../store/configureStore';

let store = configureStore();

export default class Root extends React.Component{
  render(){
    return (<Provider store={store}>
    <Router history={browserHistory}>
      <Route path='/' component={Layout}>
        <IndexRoute component={Home}/>
        <Route path="/todoApp" component={TodoApp}/>
        <Route path='/uploader' component={Uploader}/>
      </Route>
    </Router>
    </Provider>);
  }
}
