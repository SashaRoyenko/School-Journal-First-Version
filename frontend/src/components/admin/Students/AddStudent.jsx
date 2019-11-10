import React from 'react';
import classes from '../Content.module.css'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import Col from 'react-bootstrap/Col'

const AddStudent = () => {
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
        <div className={`bg-light ${classes.box} ${classes.content}`}>
            <Form noValidate validated={validated} onSubmit={handleSubmit}>
                <h2>Учень</h2>
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
                    <Form.Group as={Col} md="4" controlId="validationCustom04">
                        <Form.Label>Дата народження</Form.Label>
                        <Form.Control type="date"

                            min="1900-01-01" max="2019-10-11" />
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
                </Form.Row>
                <Form.Row>
                    <Form.Group as={Col} md="3">
                        <Form.Label>Пароль</Form.Label>
                        <Form.Control type="password" placeholder="Пароль" />
                    </Form.Group>
                </Form.Row>

                <Button type="submit">Додати учня</Button>
            </Form>
        </div>
    );
}

export default AddStudent;