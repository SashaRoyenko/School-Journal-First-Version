import React from 'react';
import classes from '../Content.module.css'
import Table from 'react-bootstrap/Table'
import Card from 'react-bootstrap/Card'
import TableRow from '../TableRow'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const TableGroups = () => {
    return (
        <div className={`bg-light  ${classes.box} ${classes.content}`}>
            <h1>Клас</h1>
            <Card>
                <Navbar bg="light">
                    <Nav className="mr-auto">
                        <LinkContainer to="/admin/add_parents">
                            <Button >+ Клас</Button>
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
                            <th>Назва класу</th>
                            <th>Класний керівник</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <TableRow group_name='11-A' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='11-Б' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='11-В' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='10-A' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='10-Б' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='10-В' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='9-A' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='9-Б' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                        <TableRow group_name='9-В' group_teacher_surname='Сторожук' group_teacher_name='Дмитро' group_teacher_secname='Батькович'/>
                    </tbody>
                </Table>
            </Card>
        </div>
    );
}

export default TableGroups;