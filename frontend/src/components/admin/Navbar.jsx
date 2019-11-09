import React from 'react';
import classes from './Navbar.module.css'
import Nav from 'react-bootstrap/Nav';
import { LinkContainer } from 'react-router-bootstrap'

const Navbar = () => {
    return (
        <aside className={`${classes.box} ${classes.sidebar}`}>
            <Nav className="flex-column">
                <Nav.Item>
                    <Nav.Link disabled>Користувачі</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/teachers">
                        <Nav.Link className="ml-2">Вчителі</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/students">
                        <Nav.Link className="ml-2">Учні</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/parents">
                        <Nav.Link className="ml-2">Батьки</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/teachers">
                        <Nav.Link>Предмети</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/teachers">
                        <Nav.Link>Класи</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/teachers">
                        <Nav.Link>Розклад</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
            </Nav>
        </aside>
    );
}

export default Navbar;