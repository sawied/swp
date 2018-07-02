import React from 'react';
import {NavLink} from 'react-router-dom';

class Navigation extends React.Component {
    render(){ return (
            <ul className="nav nav-pills nav-stacked">
             <li role="presentation"><NavLink to="/" exact={true} activeClassName="active">HOME</NavLink></li>
            <li><NavLink to="/todoApp" activeClassName="active">TODOS</NavLink></li>
            <li><NavLink to="/imager" activeClassName="active">IMAGER</NavLink></li>
            </ul>
    );
    }

}
/**
 *
const CustomLink=({label, to, activeOnlyWhenExact })=>(
    <Route
    path={to}
    exact={activeOnlyWhenExact}
    children={({ match }) => (
      <a className={match?'active':''}>
        <NavLink to={to}>{label}</NavLink>
      </a>
    )}
  />
);
 */
export default Navigation;