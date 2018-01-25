import {createStore,applyMiddleware} from 'redux';
/**
*Redux Thunk middleware allows you to write action creators that return a function instead of an action.
*The inner function receives the store methods dispatch and getState as parameters
Since 2.1.0, Redux Thunk supports injecting a custom argument using the withExtraArgument function:

for example:
const store = createStore(
  reducer,
  applyMiddleware(thunk.withExtraArgument({ api, whatever }))
)

// later
function fetchUser(id) {
  return (dispatch, getState, { api, whatever }) => {
    // you can use api and something else here here
  }
}
 */
import reduxThunk from 'redux-thunk';
// can custom logger import { createLogger } from 'redux-logger'
/**
 const logger = createLogger({
  // ...options
});
{
  predicate, // if specified this function will be called before each action is processed with this middleware.
  collapsed, // takes a Boolean or optionally a Function that receives `getState` function for accessing current store state and `action` object as parameters. Returns `true` if the log group should be collapsed, `false` otherwise.
  duration = false: Boolean, // print the duration of each action?
  timestamp = true: Boolean, // print the timestamp with each action?
 
  level = 'log': 'log' | 'console' | 'warn' | 'error' | 'info', // console's level
  colors: ColorsObject, // colors for title, prev state, action and next state: https://github.com/evgenyrodionov/redux-logger/blob/master/src/defaults.js#L12-L18
  titleFormatter, // Format the title used when logging actions.
 
  stateTransformer, // Transform state before print. Eg. convert Immutable object to plain JSON.
  actionTransformer, // Transform action before print. Eg. convert Immutable object to plain JSON.
  errorTransformer, // Transform error before print. Eg. convert Immutable object to plain JSON.
 
  logger = console: LoggerObject, // implementation of the `console` API.
  logErrors = true: Boolean, // should the logger catch, log, and re-throw errors?
 
  diff = false: Boolean, // (alpha) show diff between states?
  diffPredicate // (alpha) filter function for showing states diff, similar to `predicate`
}
 */
import logger from 'redux-logger';
import { apiMiddleware } from 'redux-api-middleware'; // RSAA = '@@redux-api-middleware/RSAA'

import rootReducer from '../reducers';

//create the root store for APP

const middleware = [ reduxThunk,apiMiddleware ];
if (process.env.NODE_ENV !== 'production') {
    middleware.push(logger);
}


const configureStore = preloadedState => createStore(
    rootReducer,
    preloadedState,
    applyMiddleware(...middleware)
);
export default configureStore;