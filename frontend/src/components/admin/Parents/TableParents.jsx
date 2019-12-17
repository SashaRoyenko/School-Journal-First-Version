import React from 'react';
import classes from '../Content.module.css'
import Table from 'react-bootstrap/Table'
import Card from 'react-bootstrap/Card'
import TableRowUsers from '../TableRowUsers'
import { Navbar, Nav, Button, Form } from 'react-bootstrap'
import { LinkContainer } from 'react-router-bootstrap'

const TableParents = () => {
    return (
        <div className={`bg-light  ${classes.box} ${classes.content}`}>
            <h1>Батьки</h1>
            <Card>
                <Navbar bg="light">
                    <Nav className="mr-auto">
                        <LinkContainer to="/admin/add_parents">
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
                        <TableRowUsers surname='Shemeliuk' name='Orest' second_name='Batkovich' email='shemel_o@gmail.com' telnum='+380XXXXXXX2'
                            surname2='Shemeliuk' name2='Marichka' second_name2='Batkivna' email2='shemel_m@gmail.com' telnum2='+380XXXXXXX7'
                        />
                        <TableRowUsers surname='Royenko' name='Olexandr' second_name='Batkovich' email='frontend_developer@yandex.ru' telnum='+380XXXXXXX3'
                            surname2='Royenko' name2='Maxym' second_name2='Batkovich' email2='backend_developer@yandex.ru' telnum2='+380XXXXXXX8'
                        />
                    </tbody>
                </Table>
            </Card>
        </div>
    );
}

export default TableParents;