import React from 'react';
import ActiveLink from './activeLink';

class Navigation extends React.Component {
    render(){ return (
            <ul className="nav nav-pills nav-stacked">
            <li role="presentation"><ActiveLink to="/" onlyActiveOnIndex>Home</ActiveLink></li>
            <li><ActiveLink to="/todos">Todo list</ActiveLink></li>
            <li><ActiveLink to="/fileManager">File manager</ActiveLink></li>
            </ul>
    );
    }

}


Navigation.defaultProps = {
};

export default Navigation;