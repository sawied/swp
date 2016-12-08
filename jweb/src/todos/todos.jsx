import React from 'react';
import { connect } from 'react-redux';
class Todos extends React.Component {




  render() {

     let todoList = this.props.todos;
     let tbody=null;
     if(todoList.length==0){

       tbody= <tbody>{todoList.map((todo,index)=>
           <tr>
             <td>{index}</td><td>{todo.text}</td><td>{todo.status}</td>
           </tr>
         )}</tbody>;

     }else{
       tbody =<tbody><tr className="center">
            <td colSpan="3">No Data to display.</td>
            </tr></tbody>;
     }


    return (
      <table className="table table-bordered">
        <caption>TO DO LIST</caption>
        <thead>
          <tr><th>Index</th><th>desc</th><th>Status</th></tr>
        </thead>
        {tbody}
      </table>
    );
  }
}


function select(state) {
  return {
    todos:state.todos
  };
}
export default  connect(select)(Todos);
