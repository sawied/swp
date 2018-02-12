import {LOAD_EVENT} from './actionTypes';


function todoReducer(state = {loading:true,todos:[]}, action){
    switch(action.type){
        case '${LOAD_EVENT}_PENDING':
        return Object.assign({},{loading:true});
        case '${LOAD_EVENT}_FULFILLED':
        return Object.assign({},{todos:action.payload.content,loading:false});
        default:
         return state;
    }
}

export default todoReducer;