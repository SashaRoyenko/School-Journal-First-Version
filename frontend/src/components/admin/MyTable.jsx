import React from 'react';
//import classes from './MyTable.module.css'
import Table from 'react-bootstrap/Table'
import TableRow from './TableRow'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'

const MyTable = () => {
    return (
        <div>
            <h1>Вчителі</h1>
            <Navbar bg="light">
                <Nav className="mr-auto">
                    <Button href="/addTeacher">+ Вчитель</Button>
                </Nav>               
                <Form inline>
                    <Form.Control type="text" placeholder="Search" className="mr-sm-2" />
                    <Button variant="outline-info">Search</Button>
                </Form>
            </Navbar>       
            <Table responsive striped bordered hover variant="light">
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Table heading</th>
                        <th>Table heading</th>
                        <th>Table heading</th>
                        <th>Table heading</th>
                        <th>Table heading</th>
                        <th>Table heading</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <TableRow surname='Storozhuk' name='Kostya' second_name='Batkovich' subject='Math' age='35'/>
                    <TableRow surname='Bortnichuk' name='Nikita' second_name='Batkovich' subject='English' age='32'/>
                </tbody>                    
            </Table>
        </div>
    );
}

export default MyTable;