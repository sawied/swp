import React from 'react';
import PropTypes from 'prop-types';
import Todo from './todo'

class TodoList extends React.Component {

    constructor(props){
        super(props);
      }

      render(){
        let {todos,onTodoClick,loading } = this.props;
        let view =<div>loading...</div>;
        if(!loading){
          view = (
            <ul>
                {todos.map((todo,index) => {
                    <Todo key={index} {...todo} onClick={()=>onTodoClick(index)}></Todo>
                })}
            </ul>
        )
        }
        return view;
      }
}

TodoList.propTypes = {
    todos: PropTypes.arrayOf(
      PropTypes.shape({
        id: PropTypes.number.isRequired,
        completed: PropTypes.bool.isRequired,
        text: PropTypes.string.isRequired
      }).isRequired
    ).isRequired,
    onTodoClick: PropTypes.func.isRequired
  }

  export default TodoList;