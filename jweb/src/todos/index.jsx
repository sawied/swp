
/**
 * container componenet
 */
import React from 'react';
import { connect } from 'react-redux';
import Adder from './components/eventAdder';
import Todolist from './components/todolist';
import * as actions from './actions';

class TodoApp extends React.Component{

    componentDidMount(){
        this.props.initHandler();
    }

    render(){
        let {todoLs,enterInputHandler,onTodoClick} = this.props;
        return (<div>
            <Adder enterInputHandler={enterInputHandler}/>
            <Todolist {...todoLs} onTodoClick={onTodoClick}/>
        </div>)
    }
}


const mapStateToProps = (state, ownProps) => {
    
    return {
      todoLs:state.todoNode
    }
  }

const mapDispatchToProps = (dispatch, ownProps) => {
    return {
        enterInputHandler:(text) => {
        dispatch(actions.addEvent(text))
      },
      onTodoClick:(id)=>{
          dispatch(actions.toggleEvent(id))
      },
      initHandler:()=>{
        dispatch(actions.loadEvents())
      }
    }
}

export default  connect(
    mapStateToProps,
    mapDispatchToProps
  )(TodoApp);
  
