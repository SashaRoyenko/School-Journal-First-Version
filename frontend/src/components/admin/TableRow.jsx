import React from 'react';
import './AdminPage.css'
import {Button, ButtonToolbar} from 'react-bootstrap'

const TableRow = (props) => {
    return (
        <tr>
            <td>{ props.group_name }</td>
            <td>{ props.group_teacher_surname } { props.group_teacher_name } { props.group_teacher_secname }</td>
            <td className="sec_col">
                <ButtonToolbar>
                    <Button variant="outline-warning" size="sm" className="mr-1">Змінити</Button>
                    <Button variant="outline-danger" size="sm">Видалити</Button>
                </ButtonToolbar>
            </td>
        </tr>
    );
}

export default TableRow;