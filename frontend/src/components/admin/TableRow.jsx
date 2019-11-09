import React from 'react';
//import classes from './TableRow.module.css'
import {Button, ButtonToolbar} from 'react-bootstrap'

const TableRow = (props) => {
    return (
        <tr>
            <td>{ props.surname }</td>
            <td>{ props.name }</td>
            <td>{ props.second_name }</td>
            <td>{ props.email }</td>
            <td>{ props.telnum }</td>
            <td>
                <ButtonToolbar>
                    <Button variant="outline-warning" size="sm" className="mr-1">Змінити</Button>
                    <Button variant="outline-danger" size="sm">Видалити</Button>
                </ButtonToolbar>
            </td>
        </tr>
    );
}

export default TableRow;