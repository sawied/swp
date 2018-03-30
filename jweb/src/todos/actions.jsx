import * as types from './actionTypes';
import service from '../services/';


export const addEvent=(text)=>{
    return {type:types.ADD_EVENT,payload:service(types.ADD_EVENT,{text})};
}


export const loadEvents=(param)=>{
    return {type:types.LOAD_EVENT,payload:service(types.LOAD_EVENT,param)};
}

export const toggleEvent=(id)=>{
    return {type:types.TOGGLE_EVENT,payload:service(types.TOGGLE_EVENT,id)};
}