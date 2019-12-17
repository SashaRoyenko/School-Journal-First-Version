import React from 'react';
import classes from './Navbar.module.css'
import Nav from 'react-bootstrap/Nav';
import { LinkContainer } from 'react-router-bootstrap'

const Navbar = () => {
    return (
        <aside className={`bg-secondary  ${classes.box} ${classes.sidebar}`}>
            <Nav className="flex-column">
                <Nav.Item>
                    <Nav.Link className="text-light" disabled>Користувачі</Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/admin/teachers">
                        <Nav.Link className="ml-2 text-light">Вчителі</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/admin/students">
                        <Nav.Link className="ml-2 text-light">Учні</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/admin/parents">
                        <Nav.Link className="ml-2 text-light">Батьки</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/admin/lessons">
                        <Nav.Link className="text-light">Предмети</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/admin/groups">
                        <Nav.Link className="text-light">Класи</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
                <Nav.Item>
                    <LinkContainer to="/teachers">
                        <Nav.Link className="text-light">Розклад</Nav.Link>
                    </LinkContainer>
                </Nav.Item>
            </Nav>
        </aside>
    );
}

export default Navbar;