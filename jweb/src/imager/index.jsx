/**
 * container componenet
 */
import React from 'react';
import { connect } from 'react-redux';
import Imager from './components/';
import * as actions from './actions';


class HomeApp extends React.Component {

    componentDidMount() {
        this.props.initHandler();
    }

    render() {
        let { url} = this.props;
        return (
            <div className="panel panel-default">
                 <Imager url= {url}/>
            </div>
        )
    }
}


const mapStateToProps = (state) => {

    return {
        url: state.imagerNode.url
    }
}

const mapDispatchToProps = (dispatch) => {
    return {
        initHandler: () => {
            dispatch(actions.loadImg())
        }
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(HomeApp);
