export const  ADD_TODO = 'ADD_TODO';
export const  RECEIVE_TODOLIST = 'RECEIVE_TODOLIST';
export const  REMOVE_ENENTS='REMOVE_ENENTS';

export function addTodo(text){
  return dispatch=>{
    var headers = new Headers();
    var data ={text};
    headers.append('Content-Type','application/json');
    return fetch('http://localhost:8900/event',{method:'post',headers:headers,body:JSON.stringify(data)}).then(
      response=>{
        var result=response.json();
        window.console.log('saved data into database',result);
        return result;
      }
    ).then(
      () => dispatch(fetchTodoList())
    );
  }
}


export const receiveTodoList = (json) => {
 return {
   type: RECEIVE_TODOLIST,
   data: json.content,
   receivedAt: Date.now()
 };
}


export function fetchTodoList(){
  return (dispatch,response)=>{
    window.console.log('getting begin fetch events list',response);
    return fetch('http://localhost:8900/event')
        .then(response=>response.json())
        .then(json=>dispatch(receiveTodoList(json)));}
}
