import React from 'react';
import { connect } from 'react-redux';
import {fetchTodoList,addTodo} from './../actions/actions';
class Todos extends React.Component {


  constructor(props){
    super(props);
    this.dispatch = this.props.dispatch;
    this.eventInput=null;
    this.state={'newEventText':null,'tids':[]};
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
             <td><input type="checkbox" onChange={this.handleChange} name="tids" value={todo.id}/></td><td>{todo.id}</td><td>{todo.text}</td><td>{todo.status}</td>
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
          <input type="text" onChange={this.handleChange}  name="newEventText" className="form-control" placeholder="Add New Event..."/>
          <span className="input-group-btn">
            <button className="btn btn-primary" type="button" onClick={this.addNewEvent}>ADD</button>
            <button className="btn btn-danger" type="button" onClick={this.deleteEvents}>DELETE</button>
          </span>
          </div>
          
  </div>
  </div>

  <table className="table table-bordered">
        
        <thead>
          <tr><th></th><th>Index</th><th>desc</th><th>Status</th></tr>
        </thead>
        {tbody}
      </table>

        </div>
    );
  }


/**
 * onChange event
 */

handleChange=(event)=>{
  const target = event.target;
  const value = target.value;
  const name = target.name;
    this.setState({
      [name]: Array.isArray(this.state[name])?[value,...this.state[name]]:value
    });
}


/**
 * handler new event
 * prevent default event and add new event into repository
 */
addNewEvent=(e)=>{
  e.preventDefault();
  window.console.log('will be add new event ...',this.state['newEventText']);
  const newEventText=this.state['newEventText'];
  if(newEventText){
    this.dispatch(addTodo(newEventText));
  }
}

/**
 * handle deleting event
 */
deleteEvents=(e)=>{
  e.preventDefault();
  window.console.log('will be delete events ...',this.state['tids']);
  this.dispatch(deleteEvents(this.state['tids']));
}







}


function select(state) {
  return {
    todos:state.todos
  };
}
export default  connect(select)(Todos);
