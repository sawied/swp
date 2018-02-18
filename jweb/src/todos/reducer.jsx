import {LOAD_EVENT} from './actionTypes';
import typeToReducer from 'type-to-reducer';

const initialState = {
    loading:true,
    todos:[]
}

const  todoReducer=typeToReducer({
    [LOAD_EVENT]:{
        PENDING:(state) => Object.assign({},state,{loading:true}),
        FULFILLED:(state,action)=>Object.assign({},{todos:action.payload.content,loading:false})
    }
},initialState);

export default todoReducer;