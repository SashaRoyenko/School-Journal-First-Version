import React from 'react';
import classes from '../Content.module.css'
import Table from 'react-bootstrap/Table'
import Card from 'react-bootstrap/Card'
import { Navbar, Nav, Button, Form, Dropdown } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'
import TableRowLessons from '../TableRowLessons';

const TableLessons = () => {
    return (
        <div className={`bg-light  ${classes.box} ${classes.content}`}>
            <h1>Список предметів для класу</h1>
            <Card>
                <Dropdown className="mb-2">
                    <Dropdown.Toggle variant="light" id="dropdown-basic">
                        Оберіть клас
                    </Dropdown.Toggle>

                    <Dropdown.Menu>
                        <Dropdown.Item href="#">10-А</Dropdown.Item>
                        <Dropdown.Item href="#">10-Б</Dropdown.Item>
                        <Dropdown.Item href="#">10-В</Dropdown.Item>
                    </Dropdown.Menu>
                </Dropdown>
                <Navbar bg="light">
                    <Nav className="mr-auto">
                        <LinkContainer to="/admin/add_parents">
                            <Button >+ Предмет</Button>
                        </LinkContainer>
                    </Nav>
                    <Form inline>
                        <Form.Control type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-info">Пошук</Button>
                    </Form>
                </Navbar>
                <Table responsive striped bordered hover variant="light">
                    <thead>
                        <tr>
                            <th>Предмет</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <TableRowLessons lesson_name='Математика'/>
                        <TableRowLessons lesson_name='Українська мова'/>
                        <TableRowLessons lesson_name='Фізика'/>
                        <TableRowLessons lesson_name='Інформатика'/>
                        <TableRowLessons lesson_name='Чечня'/>
                        <TableRowLessons lesson_name='Донбасс'/>
                        <TableRowLessons lesson_name='Молдова'/>

                    </tbody>
                </Table>
            </Card>
        </div>
    );
}

export default TableLessons;