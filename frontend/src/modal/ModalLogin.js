import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "./ModalLogin.css";
import LoginService from '../service/LoginService';
import React from 'react';

const errorMessage = '';

function login(props){

    var requestLogin = LoginService.realizeLogin(props);

    if(requestLogin !== '200'){
       this.errorMessage = requestLogin;
    }else{

    }

}

const ModalLogin = (props) => {

    return (

        <Modal
            {...props}
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
                
            <Modal.Header closeButton
            id = "modal-header">
                <Modal.Title id = "modal-title">Login</Modal.Title>
            </Modal.Header>

            <Modal.Body id = "modal-body">
                <Form id = "form-body" >
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label id = "email-adress-form">Email address</Form.Label>
                        <Form.Control id = "control-form-email"
                            type="email"
                            placeholder="name@example.com"
                            autoFocus
                        />
                    </Form.Group>
                    <Form.Group
                        className="mb-3"
                        controlId="exampleForm.ControlTextarea1"
                    >
                        <Form.Label id = "password-form">Password</Form.Label>
                        <Form.Control id = "control-form-email"
                            type="password"
                            placeholder="!LkMn87/"
                        />
                        <p id= "error-area">{errorMessage}</p>
                    </Form.Group>
                </Form>
            </Modal.Body>

            <Modal.Footer id = "modal-footer">
                <Button variant="primary" type="submit" >Login</Button>
                <Button variant="secondary" onClick={props.onHide}>Close</Button>
            </Modal.Footer>
                
        </Modal>

    );

}

export default ModalLogin;