import {LOAD_IMG} from './actionTypes';
import typeToReducer from 'type-to-reducer';

const initialState = {
    url:null
}

const  todoReducer=typeToReducer({
    [LOAD_IMG]:{
        PENDING:(state) => Object.assign({},state,{loading:true}),
        FULFILLED:(state,action)=>Object.assign({},state,{url:tourl(action.payload)})
    }
},initialState);

const tourl=(data)=>{
    var url = window.URL || window.webkitURL;
    return url.createObjectURL(data);
}

export default todoReducer;