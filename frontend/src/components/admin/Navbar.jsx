import React from 'react';
import classes from './Navbar.module.css'
import Nav from 'react-bootstrap/Nav';

const Navbar = () => {
    return (
        <aside className={`${classes.box} ${classes.sidebar}`}>
            <Nav variant="pills" defaultActiveKey="/home" className="flex-column">
                <Nav.Item>
                    <Nav.Link href="/teachers">Вчителі</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/students">Учні</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link href="/parents">Батьки</Nav.Link>
                </Nav.Item>
            </Nav>
        </aside>
    );
}

export default Navbar;