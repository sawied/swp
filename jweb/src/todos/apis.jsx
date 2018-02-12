import * as types from './actionTypes';

export default {
    [types.LOAD_EVENT]:{
        endpoint:'http://localhost:8900/event',
        method:'GET',
        headers:{'Content-Type': 'application/json'},
        options:{timeout:3000}
    }
}