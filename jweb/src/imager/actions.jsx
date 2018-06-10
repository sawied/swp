import * as types from './actionTypes';
import service from '../services/';

export const loadImg=(param)=>{
    return {type:types.LOAD_IMG,payload:service(types.LOAD_IMG,param)};
}