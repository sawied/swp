import React from 'react';

class UserProfile extends React.Component {
  render() {
    return (
      <div className="user-profile-panal">
        <span className="profile-detail-icon glyphicon glyphicon-chevron-down"></span>
        <div className="profile-name">
            <span className="profile-main-name">Danan</span>
            <span className="sub-name">sawied idea</span>
        </div>
      </div>
    );
  }
}

export default UserProfile;
