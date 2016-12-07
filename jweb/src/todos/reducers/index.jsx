import { combineReducers } from 'redux'
import todos from './reducer'

const todoApp = combineReducers({
  todos
})

export default todoApp
