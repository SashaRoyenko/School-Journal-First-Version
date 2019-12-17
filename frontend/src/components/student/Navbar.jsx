import React from 'react';
import classes from './Navbar.module.css'
import Nav from 'react-bootstrap/Nav';
import { LinkContainer } from 'react-router-bootstrap'

const Navbar = () => {
    return (
        <aside className={`  ${classes.box} ${classes.sidebar}`}>
            <Nav className="flex-column">
                <Nav.Item>
                    <LinkContainer to="/student/profile">
                        <Nav.Link className="ml-2 text-dark">Ваш профіль</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/admin/schedule">
                        <Nav.Link className="ml-2 text-dark">Розклад уроків</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/student/journal">
                        <Nav.Link className="ml-2 text-dark">Журнал</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/student/hometasks">
                        <Nav.Link className="ml-2 text-dark">Домашні завдання</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
            </Nav>
        </aside>
    );
}

export default Navbar;