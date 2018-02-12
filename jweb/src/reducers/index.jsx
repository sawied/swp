import { combineReducers } from 'redux';
import todoNode from '../todos/reducer';
import error from './reducer';

const rootReducer = combineReducers({
  todoNode,error
})

export default rootReducer
