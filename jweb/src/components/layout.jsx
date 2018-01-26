//require('normalize.css/normalize.css');
require('styles/jweb.scss');

import React from 'react';
import UserProfile from './userProfile';
import Navigation from './navigation';


class Layout extends React.Component {
  render() {
    return (
      <div id="app-root">
        <div className="header">
        </div>
        <div id="app-body">
        <div className="left-panel">
        <UserProfile/>
        <Navigation/>
        </div>
        <div className="right-panel">
          {this.props.children}
        </div>
        </div>
        <div className="footer"></div>
      </div>
    );
  }
}

Layout.defaultProps = {
};

export default Layout;
