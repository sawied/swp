import * as types from './actionTypes';

export default {
    [types.LOAD_IMG]:{
        endpoint:'http://localhost:8888/microservice-resource-SNAPSHOT/resources/microservice-CI.jpg',
        method:'GET',
        options:{timeout:3000}
    }
}