import React from 'react';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Form from 'react-bootstrap/Form'
import Button from 'react-bootstrap/Button'
import Col from "react-bootstrap/Col";


const SignIn = () => {

    return (
        <Container>
            <Row>
                <Col lg={{ span: 4, offset: 4 }} style={{marginTop: 150}}>
                    <h1>
                        Вхід
                    </h1>
                    <Form>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Логін</Form.Label>
                            <Form.Control type="text" placeholder="Введіть логін"/>
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Пароль</Form.Label>
                            <Form.Control type="password" placeholder="Пароль"/>
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Увійти
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
        
    );

}

export default SignIn;
