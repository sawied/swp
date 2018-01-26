
import React from 'react';
import {Provider} from 'react-redux';
import Layout from './layout';
import Home from './Home';
import FileManager from './FileManager';
import Todos from './todos';
import {Router,Route,browserHistory,IndexRoute} from 'react-router';
import configureStore from './../store/configureStore';

let store = configureStore();

export default class Root extends React.Component{
  render(){
    return (<Provider store={store}>
    <Router history={browserHistory}>
      <Route path='/' component={Layout}>
        <IndexRoute component={Home}/>
        <Route path="/todos" component={Todos}/>
        <Route path='/fileManager' component={FileManager}/>
      </Route>
    </Router>
    </Provider>);
  }
}
