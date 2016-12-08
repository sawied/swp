export const  AAD_TODO = 'ADD_TODO';

export function addTodo(text){
  return {type:ADD_TODO,text};
}
