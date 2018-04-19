export default function(state={display:false},action){
    if(action.type==='GLOBAL_ERROR'){
      return Object.assign({},{display:action.display,error:action.error});
    }else{
      return state;
    }

}