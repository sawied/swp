import React from 'react';
import ActiveLink from './activeLink';

class Navigation extends React.Component {
    render(){ return (
            <ul className="nav nav-pills nav-stacked">
            <li role="presentation"><ActiveLink to="/" onlyActiveOnIndex>HOME</ActiveLink></li>
            <li><ActiveLink to="/todoApp">TODOS</ActiveLink></li>
            <li><ActiveLink to="/uploader">UPLOADER</ActiveLink></li>
            </ul>
    );
    }

}


Navigation.defaultProps = {
};

export default Navigation;