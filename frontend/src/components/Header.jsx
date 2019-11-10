import React from 'react';
import classes from './Header.module.css'
import Navbar from 'react-bootstrap/Navbar';

const Header = () => {
    return (
        <header className={`bg-dark ${classes.box} ${classes.header}`}>
            <Navbar>
                <Navbar.Brand className="mr-auto font-weight-bold text-light" href="#home">E-JOURNAL</Navbar.Brand>
                <Navbar.Text className="font-weight-light text-secondary">
                    Ви увійшли як: <a className="font-weight-bold text-light" href="#login">admin</a><br></br>
                    <a className="text-light" href="#logout">Вийти</a>
                </Navbar.Text>
            </Navbar>
        </header>
    );
}

export default Header;