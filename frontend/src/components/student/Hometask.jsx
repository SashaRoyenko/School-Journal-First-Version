import React from 'react';
import classes from './Content.module.css'
import Table from 'react-bootstrap/Table';
import Dropdown from 'react-bootstrap/Dropdown';

const Hometask = () => {
    return (
        <div className={`${classes.box} ${classes.content}`}>
            <h2 className="mb-3">Домашні завдання учня</h2>
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
                        <th>Дата</th>
                        <th>Завдання</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>01.09.2019</td>
                        <td>№225,№225,№225,№225,№225,№225,</td>
                    </tr>    
                    <tr>
                        <td>01.09.2019</td>
                        <td>№225,№225,№225, підготуватись до ср</td>
                    </tr>
                    <tr>
                        <td>01.09.2019</td>
                        <td> - </td>
                    </tr>
                    <tr>
                        <td>01.09.2019</td>
                        <td>№225,№225,№225,№225,№225, книга стр. 100-500</td>
                    </tr>
                    <tr>
                        <td>01.09.2019</td>
                        <td>№225,№225,№225,№225,№225,№225, конспект</td>
                    </tr>
                    <tr>
                        <td>01.09.2019</td>
                        <td>№225,№225,№225,№225, підготуватись до ЗНО</td>
                    </tr>
                    <tr>
                        <td>01.09.2019</td>
                        <td> - </td>
                    </tr>
                </tbody>
            </Table>
        </div>
    );
}

export default Hometask;