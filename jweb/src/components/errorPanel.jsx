
/**
 * container componenet
 */
import React from 'react';
import { connect } from 'react-redux';

class ErrorPanel extends React.Component{

    render(){
        let {display,error,closeHandler} = this.props;
        if(display){
            return  (<div className='alert alert-danger alert-dismissible' id='error-panel'>
                    <button type="button" className="close" onClick={closeHandler}><span aria-hidden="true">&times;</span></button>
                <span><strong>Error: </strong> {error.message}</span>
            </div>)
        }
        return null;
    }
}


const mapStateToProps = (state) => {
    
    return state.error
    
  }

const mapDispatchToProps = (dispatch) => {
    return {
        'closeHandler':()=>{
            dispatch({type:'GLOBAL_ERROR',display:false,error:null});
        }
    }
}

export default  connect(
    mapStateToProps,
    mapDispatchToProps
  )(ErrorPanel);
  
