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
                        Sign In
                    </h1>
                    <Form>
                        <Form.Group controlId="formBasicEmail">
                            <Form.Label>Login</Form.Label>
                            <Form.Control type="text" placeholder="Enter login"/>
                        </Form.Group>

                        <Form.Group controlId="formBasicPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password"/>
                        </Form.Group>

                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
        
    );

}

export default SignIn;
