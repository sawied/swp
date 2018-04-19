import React from 'react';
import PropTypes from 'prop-types';

class Todo extends React.Component {

    constructor(props){
        super(props);
        this.state = {
        };
      }
      
      componentDidMount(){
      }

      render(){
        let {onClick,completed,text} = this.props;
        return (
            <li
            className='list-group-item'
            onClick={onClick}
            style={{
                textDecoration: completed ? 'line-through' : 'none'
              }}
              >
              {text}
            </li>
        )
      }
     

}


//define
Todo.propTypes={
    onClick:PropTypes.func.isRequired,
    completed:PropTypes.bool.isRequired,
    text:PropTypes.string.isRequired
}

export default  Todo;