export const  ADD_TODO = 'ADD_TODO';
export const  RECEIVE_TODOLIST = 'RECEIVE_TODOLIST';

export function addTodo(text){
  return dispatch=>{
    var headers = new Headers();
    var data ={text};
    headers.append('Content-Type','application/json');
    return fetch('http://localhost:8900/event',{method:'post',headers:headers,body:JSON.stringify(data)}).then(
      response=>response.json()
    ).then(
      dispatch(fetchTodoList())
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
 return dispatch=>{ return fetch('http://localhost:8900/event')
        .then(response=>response.json())
        .then(json=>dispatch(receiveTodoList(json)));}
}
