import {createStore,applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import createLogger from 'redux-logger';
import {Provider} from 'react-redux';

//create the root start for APP
const middleware = [ thunk ];
if (process.env.NODE_ENV !== 'production') {
  middleware.push(createLogger());
}

export default function createDefaultStore(reducers){

   return  createStore(reducers,applyMiddleware(...middleware));
}
