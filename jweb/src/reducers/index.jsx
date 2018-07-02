import { combineReducers } from 'redux';
import todoNode from '../todos/reducer';
import imagerNode from '../imager/reducer';
import error from './reducer';

const rootReducer = combineReducers({
  todoNode,imagerNode,error
})

export default rootReducer
