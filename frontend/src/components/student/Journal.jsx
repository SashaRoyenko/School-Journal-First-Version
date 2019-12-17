import React from 'react';
import classes from './Content.module.css'
import Table from 'react-bootstrap/Table';
import Dropdown from 'react-bootstrap/Dropdown';

const Journal = () => {
    return (
        <div className={`${classes.box} ${classes.content}`}>
            <h2 className="mb-3">Журнал оцінок учня</h2>
            <Dropdown className="mb-2">
                <Dropdown.Toggle variant="light" id="dropdown-basic">
                    Оберіть предмет
                </Dropdown.Toggle>

                <Dropdown.Menu>
                    <Dropdown.Item href="#">Алгебра</Dropdown.Item>
                    <Dropdown.Item href="#">Фізика</Dropdown.Item>
                    <Dropdown.Item href="#">Українська мова</Dropdown.Item>
                </Dropdown.Menu>
            </Dropdown>
            <Table variant="light" striped bordered hover responsive >
                <thead>
                    <tr>
                        <th>Предмет</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                        <th>01.09.2019</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Алгебра</td>
                        <td>10</td>
                        <td></td>
                        <td>12</td>
                        <td>10</td>
                        <td>н</td>
                        <td>12</td>
                        <td>10</td>
                        <td></td>
                        <td>12</td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
}

export default Journal;