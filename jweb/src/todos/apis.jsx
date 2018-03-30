import * as types from './actionTypes';

export default {
    [types.LOAD_EVENT]:{
        endpoint:'http://localhost:8900/event',
        method:'GET',
        headers:{'Content-Type': 'application/json'},
        options:{timeout:3000}
    },
    [types.ADD_EVENT]:{
        endpoint:'http://localhost:8900/event',
        method:'POST',
        headers:{'Content-Type': 'application/json'}
    },
    [types.TOGGLE_EVENT]:{
        endpoint:(id)=>`http://localhost:8900/event/${id}`,
        method:'PUT'
    }
}