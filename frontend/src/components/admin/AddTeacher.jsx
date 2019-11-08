import React from 'react';
import classes from './AddTeacher.module.css'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import InputGroup from 'react-bootstrap/InputGroup'
import Col from 'react-bootstrap/Col'

const AddTeacher = () => {
    const [validated, setValidated] = React.useState(false);

    const handleSubmit = event => {
        const form = event.currentTarget;
        if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
        }

        setValidated(true);
    };

    return (
        <Form noValidate validated={validated} onSubmit={handleSubmit}>
            <h2>Додати вчителя</h2>
            <Form.Row>
                <Form.Group as={Col} md="4" controlId="validationCustomLogin">
                    <Form.Label>Логін</Form.Label>
                    <Form.Control
                        type="text"
                        placeholder="Логін"
                        aria-describedby="inputGroupPrepend"
                        required
                        defaultValue=""
                    />
                    <Form.Control.Feedback type="invalid">
                        Будь ласка, напишіть логін.
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group as={Col} md="4" controlId="validationCustomTel">
                    <Form.Label>Телефон</Form.Label>
                    <Form.Control
                        type="tel"
                        placeholder="Номер телефону"
                        aria-describedby="inputGroupPrepend"
                        required
                        defaultValue=""
                    />
                    <Form.Control.Feedback type="invalid">
                        Будь ласка напишіть номер телефону.
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group as={Col} md="4" controlId="validationCustomEmail">
                    <Form.Label>Електронна пошта</Form.Label>
                    <Form.Control
                        required
                        type="email"
                        placeholder="Електронна пошта"
                        defaultValue=""
                    />
                    <Form.Control.Feedback type="invalid">
                        Будь ласка напишіть пошту.
                    </Form.Control.Feedback>
                </Form.Group>
            </Form.Row>
            <Form.Row>
                <Form.Group as={Col} md="4" controlId="validationCustom01">
                    <Form.Label>Прізвище</Form.Label>
                    <Form.Control
                        required
                        type="text"
                        placeholder="Прізвище"
                        defaultValue=""
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                </Form.Group>
                <Form.Group as={Col} md="4" controlId="validationCustom02">
                    <Form.Label>Ім'я</Form.Label>
                    <Form.Control
                        required
                        type="text"
                        placeholder="Ім'я"
                        defaultValue=""
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                </Form.Group>
                <Form.Group as={Col} md="4" controlId="validationCustom03">
                    <Form.Label>По батькові</Form.Label>
                    <Form.Control
                        required
                        type="text"
                        placeholder="По батькові"
                        defaultValue=""
                    />
                    <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                </Form.Group>
            </Form.Row>
            <Form.Row>
                <Form.Group as={Col} md="6" controlId="validationCustom03">
                    <Form.Label>Адреса</Form.Label>
                    <Form.Control type="text" placeholder="Адреса проживання" required />
                    <Form.Control.Feedback type="invalid">
                        Введіть адресу
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group as={Col} md="3" controlId="validationCustom04">
                    <Form.Label>Дата народження</Form.Label>
                    <Form.Control type="date" value="" min="1900-01-01" max="2019-01-01" required />
                    <Form.Control.Feedback type="invalid">
                        Введіть дату.
                    </Form.Control.Feedback>
                </Form.Group>
                <Form.Group as={Col} md="3" controlId="validationCustom05">
                    <Form.Label>Zip</Form.Label>
                    <Form.Control type="text" placeholder="Zip" required />
                    <Form.Control.Feedback type="invalid">
                        Please provide a valid zip.
                    </Form.Control.Feedback>
                </Form.Group>
            </Form.Row>
            <Form.Group>
                <Form.Check
                    required
                    label="Agree to terms and conditions"
                    feedback="You must agree before submitting."
                />
            </Form.Group>
            <Button type="submit">Submit form</Button>
        </Form>
    );
}


export default AddTeacher;