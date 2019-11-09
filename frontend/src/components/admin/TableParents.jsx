import React from 'react';
//import classes from './MyTable.module.css'
import Table from 'react-bootstrap/Table'
import TableRow from './TableRow'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const TableParents = () => {
    return (
        <div>
            <h1>Батьки</h1>
            <Navbar bg="light">
                <Nav className="mr-auto">
                    <LinkContainer to="/add_parents">
                        <Button >+ Батьки</Button>
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
                    <TableRow surname='Shemeliuk' name='Orest' second_name='Batkovich' email='shemel@gmail.com' telnum='+380XXXXXXX2'/>
                    <TableRow surname='Royenko' name='Olexandr' second_name='Batkovich' email='frontend_developer@yandex.ru' telnum='+380XXXXXXX3'/>
                </tbody>                    
            </Table>
        </div>
    );
}

export default TableParents;