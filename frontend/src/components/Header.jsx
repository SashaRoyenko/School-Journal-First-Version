import React from 'react';
import classes from './Header.module.css'
import Navbar from 'react-bootstrap/Navbar';

const Header = () => {
    return (
        <header className={`${classes.box} ${classes.header}`}>
            <Navbar>
                <Navbar.Brand className="mr-auto" href="#home">E-JOURNAL</Navbar.Brand>
                <Navbar.Text >
                    Ви увійшли як: <a href="#login">admin</a><br></br>
                    <a href="#logout">Вийти</a>
                </Navbar.Text>
            </Navbar>
        </header>
    );
}

export default Header;