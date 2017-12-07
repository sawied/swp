import React from 'react';
import { connect } from 'react-redux';
import {fetchTodoList,addTodo} from './../actions/actions';
class Todos extends React.Component {


  constructor(props) {
    super(props);
    this.dispatch = this.props.dispatch;
    this.eventInput=null;
  }

 componentDidMount(){
  
   this.dispatch(fetchTodoList(this.dispatch));
 }

  render() {

     let todoList = this.props.todos;
     let tbody=null;
     if(todoList.length!==0){

       tbody= <tbody>{todoList.map((todo,index)=>
           <tr key={todo.id}>
             <td>{index}</td><td>{todo.text}</td><td>{todo.status}</td>
           </tr>
         )}</tbody>;

     }else{
       tbody =<tbody><tr className="center">
            <td colSpan="3">No Data to display.</td>
            </tr></tbody>;
     }


    return (

        <div className="task-list-container">
        <div className="row">

        <div className="col-md-6">
         <span>TODO lIST</span>
          </div>
  
          <div className="col-md-6">
          <div className="input-group">
          <input type="text" ref={(input)=>{this.eventInput=input;}} className="form-control" placeholder="Add New Event..."/>
          <span className="input-group-btn">
            <button className="btn btn-primary" type="button" onClick={this.addNewEvent}>ADD</button>
          </span>
          </div>
  </div>
  </div>

  <table className="table table-bordered">
        
        <thead>
          <tr><th>Index</th><th>desc</th><th>Status</th></tr>
        </thead>
        {tbody}
      </table>

        </div>
    );
  }

/**
 * handler new event
 * prevent default event and add new event into repository
 */
addNewEvent=(e)=>{
  e.preventDefault();
  window.console.log('will be add new event ...',this.eventInput.value);
  if(this.eventInput.value){
    this.dispatch(addTodo(this.eventInput.value));
  }
}







}


function select(state) {
  return {
    todos:state.todos
  };
}
export default  connect(select)(Todos);
