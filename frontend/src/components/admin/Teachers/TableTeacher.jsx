import React from 'react';
import classes from '../Content.module.css'
import Table from 'react-bootstrap/Table'
import Card from 'react-bootstrap/Card'
import TableRow from '../TableRow'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const TableTeacher = () => {
    return (
        <div className={`bg-light ${classes.box} ${classes.content}`}>
            <h1>Вчителі</h1>
            <Card>
                <Navbar bg="light">
                    <Nav className="mr-auto">
                        <LinkContainer to="/admin/add_teacher">
                            <Button >+ Вчитель</Button>
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
                        <TableRow surname='Storozhuk' name='Kostya' second_name='Batkovich' email='kostik@gmail.com' telnum='+380685529917' />
                        <TableRow surname='Bortnichuk' name='Nikita' second_name='Batkovich' email='bortik@gmail.com' telnum='+380XXXXXXX1' />
                        <TableRow surname='Storozhuk' name='Kostya' second_name='Batkovich' email='kostik@gmail.com' telnum='+380685529917' />
                        <TableRow surname='Bortnichuk' name='Nikita' second_name='Batkovich' email='bortik@gmail.com' telnum='+380XXXXXXX1' />
                        <TableRow surname='Storozhuk' name='Kostya' second_name='Batkovich' email='kostik@gmail.com' telnum='+380685529917' />
                        <TableRow surname='Bortnichuk' name='Nikita' second_name='Batkovich' email='bortik@gmail.com' telnum='+380XXXXXXX1' />

                    </tbody>
                </Table>
            </Card>
        </div>
    );
}

export default TableTeacher;