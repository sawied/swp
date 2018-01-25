import React from 'react'
import { Link } from 'react-router'

class ActiveLink extends React.Component{
  render() {
    return <Link {...this.props} activeClassName="active"/>
  }
}


export default ActiveLink;
