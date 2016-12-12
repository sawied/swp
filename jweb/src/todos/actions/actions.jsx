export const  ADD_TODO = 'ADD_TODO';
export const  RECEIVE_TODOLIST = 'RECEIVE_TODOLIST';

export function addTodo(text){
  return {type:ADD_TODO,text};
}


export const receiveTodoList = (json) => ({
  type: RECEIVE_TODOLIST,
  todoList: json.data.map(child => child.data),
  receivedAt: Date.now()
})


export function fetchTodoList(dispatch){
 return fetch('data/todoList.json')
        .then(response=>response.json)
        .then(json=>dispatch(receiveTodoList(json)));
}
