import React from 'react';
//import classes from './MyTable.module.css'
import Table from 'react-bootstrap/Table'
import TableRow from './TableRow'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const TableStudents = () => {
    return (
        <div>
            <h1>Учні</h1>
            <Navbar bg="light">
                <Nav className="mr-auto">
                    <LinkContainer to="/add_student">
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
                    <TableRow surname='Mishin' name='Myhaylo' second_name='Batkovich' email='satanist@gmail.com' telnum='+380XXXXXXX5'/>
                    <TableRow surname='Golub' name='Vitalya' second_name='Batkovich' email='ptichka@ukr.net' telnum='+380XXXXXXX6'/>
                </tbody>                    
            </Table>
        </div>
    );
}

export default TableStudents;