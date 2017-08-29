import {createStore,applyMiddleware} from 'redux';
import thunk from 'redux-thunk';
import createLogger from 'redux-logger';

//create the root start for APP
const middleware = [ thunk ];
if (process.env.NODE_ENV !== 'production') {
  middleware.push(createLogger());
}

export default function createDefaultStore(rootReducer){

   return  createStore(rootReducer,applyMiddleware(...middleware));
}
