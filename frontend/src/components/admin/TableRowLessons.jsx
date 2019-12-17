import React from 'react';
import './AdminPage.css'
import {Button, ButtonToolbar} from 'react-bootstrap'

const TableRowLessons = (props) => {
    return (
        <tr>
            <td>{ props.lesson_name }</td>
            <td className="sec_col">
                <ButtonToolbar>
                    <Button variant="outline-warning" size="sm" className="mr-1">Змінити</Button>
                    <Button variant="outline-danger" size="sm">Видалити</Button>
                </ButtonToolbar>
            </td>
        </tr>
    );
}

export default TableRowLessons;