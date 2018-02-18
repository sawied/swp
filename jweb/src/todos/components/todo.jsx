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


Todo.defaultProps = {};

//define
Todo.propTypes={
    onClick:PropTypes.func.isRequired,
    completed:PropTypes.bool.isRequired,
    text:PropTypes.string.isRequired
}

export default  Todo;