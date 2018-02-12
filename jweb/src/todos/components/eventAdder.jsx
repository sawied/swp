import React from 'react';
import PropTypes from 'prop-types';


class EventAdder extends React.Component{

    constructor(props){
        super(props);
        this.enterInputHandler =this.props.enterInputHandler;
      }

      render(){
          
        return (
            <div>
                <input onKeyDown={this.handleAddEvent} type="text" name="eventText" placeholder="Please input what you will do here."/>
            </div>
        )
      }

      handleAddEvent = (e) => {
          if(e.which==13&&e.target.value){
              this.enterInputHandler(e.target.value);
          }
      }

}

EventAdder.propTypes = {
    enterInputHandler:PropTypes.func.isRequired
  }

export default EventAdder;