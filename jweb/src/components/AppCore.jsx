require('normalize.css/normalize.css');
require('styles/jweb.scss');

import React from 'react';
import CustLink from './CustLink';


class AppCore extends React.Component {
  render() {
    return (
      <div id="app-root">
        <div className="header">
          <p>React Training</p>
        </div>
        <div id="app-body">
        <div className="left-panel">
          <ul>
            <li><CustLink to="/" onlyActiveOnIndex>Home</CustLink></li>
            <li><CustLink to="/todos">Todos</CustLink></li>
            <li><CustLink to="/fileManager">File Manager</CustLink></li>
          </ul>
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

AppCore.defaultProps = {
};

export default AppCore;
