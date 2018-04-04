
/**
 * container componenet
 */
import React from 'react';
import { connect } from 'react-redux';
import Adder from './components/eventAdder';
import Todolist from './components/todolist';
import * as actions from './actions';

class TodoApp extends React.Component {

    componentDidMount() {
        this.props.initHandler();
    }

    render() {
        let { todoList, enterInputHandler, onTodoClick } = this.props;
        return (
            <div className="panel panel-default">
                 
                <div className="panel-heading">
                    <div className="todo-panel-title">
                    <span>TODO LIST</span>
                    <Adder className="todo-panel-adder" enterInputHandler={enterInputHandler} />
                    </div>
                </div>

                 <Todolist {...todoList} onTodoClick={onTodoClick} />

            </div>
        )
    }
}


const mapStateToProps = (state) => {

    return {
        todoList: state.todoNode
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        enterInputHandler: (text) => {
            dispatch(actions.addEvent(text)).then(() => dispatch(actions.loadEvents()));
        },
        onTodoClick: (id) => {
            dispatch(actions.toggleEvent(id)).then(()=>dispatch(actions.loadEvents()));
        },
        initHandler: () => {
            dispatch(actions.loadEvents())
        }
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(TodoApp);

