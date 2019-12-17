import React from 'react';
//import classes from './TableRow.module.css'
import {Button, ButtonToolbar} from 'react-bootstrap'

const TableRowUsers = (props) => {
    return (
        <tr>
            <td>{ props.surname }<br/>{ props.surname2 }</td>
            <td>{ props.name }<br/>{ props.name2 }</td>
            <td>{ props.second_name }<br/>{ props.second_name2 }</td>
            <td>{ props.email }<br/>{ props.email2 }</td>
            <td>{ props.telnum }<br/>{ props.telnum2 }</td>
            <td>
                <ButtonToolbar>
                    <Button variant="outline-warning" size="sm" className="mr-1">Змінити</Button>
                    <Button variant="outline-danger" size="sm">Видалити</Button>
                </ButtonToolbar>
            </td>
        </tr>
    );
}

export default TableRowUsers;