import React from 'react';
import classes from './Footer.module.css'

const Footer = () => {
   return(
      <footer className={`bg-dark d-flex ${classes.box} ${classes.footer}`}>
         <small className="font-weight-light text-light m-auto">© E-JOURNAL. KSON Team. 2019</small>
      </footer>
   );
  }
  
  export default Footer;