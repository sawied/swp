import React from 'react'
import { Link } from 'react-router'

class CustLink extends React.Component{
  render() {
    return <Link {...this.props} activeClassName="link-active"/>
  }
}


export default CustLink;
