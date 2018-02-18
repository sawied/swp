
/**
 * container componenet
 */
import React from 'react';
import { connect } from 'react-redux';

class ErrorPanel extends React.Component{


    constructor(props){
        super(props);
        this.timeoutMS=2000;
        this.state={
            collapse:true
        }
        this.timeoutHandler=this.resolveDisplayTimeout.bind(this);
    }

   /** getInitialState(){
        return {collapse:true};
    }**/

    componentWillReceiveProps(nextProps){
        if(nextProps.error){
            this.setState({collapse:false});
            setTimeout(this.timeoutHandler,this.timeoutMS);
        }
    }

    render(){
        let {error} = this.props;
        var status =this.state.collapse?'error-panel-collapse':'error-panel-extend';
       
            return  (<div className={'alert alert-danger '+status} id='error-panel'>
                    <button type="button" className="close"><span aria-hidden="true">&times;</span></button>
                <span><strong>Error: </strong> {error&&error.message?error.message:null}</span>
            </div>)
       
    }

    resolveDisplayTimeout(){
        this.setState({collapse:true});
    }
}

ErrorPanel.defaultProps={
    error:null
}




const mapStateToProps = (state) => {
    
    return state.error
    
  }

const mapDispatchToProps = (dispatch) => {
    return {
        'closeHandler':()=>{
            dispatch({type:'GLOBAL_ERROR',error:null});
        }
    }
}

export default  connect(
    mapStateToProps,
    mapDispatchToProps
  )(ErrorPanel);
  
