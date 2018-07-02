import React from 'react';

class Imager extends React.Component {
  render() {

    let {url} = this.props;

    return (

      <div id="home-container">
         <div>Home</div>
         <div className="home-content" id="home-content">
         {url?(<img src={url} className='imager-style'></img>):('no image display.')}
         </div>
      </div>
    );
  }
}

export default Imager;
