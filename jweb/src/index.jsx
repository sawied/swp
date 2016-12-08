import 'core-js/fn/object/assign';
import React from 'react';
import ReactDOM from 'react-dom';
import {createStore,applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import createLogger from 'redux-logger';
import {Provider} from 'react-redux';
import App from './components/AppCore';
import Home from './components/Home';
import FileManager from './components/FileManager';
import Todos from './todos/todos';
import TodosReducers from './todos/reducers';
import {Router,Route,browserHistory,IndexRoute} from 'react-router';


//create the root start for APP
const middleware = [ thunk ];
if (process.env.NODE_ENV !== 'production') {
  middleware.push(createLogger());
}


let store = createStore(TodosReducers,applyMiddleware(...middleware));

// Render the main component into the dom
ReactDOM.render(
  <Provider store={store}>
  <Router history={browserHistory}>
    <Route path='/' component={App}>
      <IndexRoute component={Home}/>
      <Route path="/todos" component={Todos}/>
      <Route path='/fileManager' component={FileManager}/>
    </Route>
  </Router>
</Provider>
, document.getElementById('app-container'));
