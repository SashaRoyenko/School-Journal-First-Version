import React from 'react';
import classes from '../Content.module.css'
import Table from 'react-bootstrap/Table'
import Card from 'react-bootstrap/Card'
import TableRowUsers from '../TableRowUsers'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const TableStudents = () => {
    return (
        <div className={`bg-light  ${classes.box} ${classes.content}`}>
            <h1>Учні!!</h1>
            <Card>
                <Navbar bg="light">
                    <Nav className="mr-auto">
                        <LinkContainer to="/admin/add_student">
                            <Button >+ Учень</Button>
                        </LinkContainer>
                    </Nav>
                    <Form inline>
                        <Form.Control type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-info">Search</Button>
                    </Form>
                </Navbar>
                <Table responsive striped bordered hover variant="light">
                    <thead>
                        <tr>
                            <th>Прізвище</th>
                            <th>Ім'я</th>
                            <th>Побатькові</th>
                            <th>E-mail</th>
                            <th>Телефон</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <TableRowUsers surname='Mishin' name='Myhaylo' second_name='Batkovich' email='satanist@gmail.com' telnum='+380XXXXXXX5' />
                        <TableRowUsers surname='Golub' name='Vitalya' second_name='Batkovich' email='ptichka@ukr.net' telnum='+380XXXXXXX6' />
                    </tbody>
                </Table>
            </Card>
        </div>
    );
}

export default TableStudents;