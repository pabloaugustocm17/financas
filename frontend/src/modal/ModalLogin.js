import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "./ModalLogin.css";
import RealizeLogin from '../service/RealizeLogin';
import React, {useState} from 'react';

async function login(email, password){

    const response = await RealizeLogin(email, password);

    return response;

}

const ModalLogin = (props) => {

    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[errorMessage, setErrorMessage] = useState("");

    const handleLogin = async () =>{
        const response = await login(email,password);
        setErrorMessage(response);
    }

    const handleClose = () => {

        setErrorMessage('');
        props.onHide();

    }

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
                    <p id= "error-area">{errorMessage}</p>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label id = "email-adress-form">Email address</Form.Label>
                        <Form.Control
                            type="email"
                            placeholder="name@example.com"  
                            onChange={(e) => setEmail(e.target.value)}    
                            autoFocus
                        />
                    </Form.Group>
                    <Form.Group
                        className="mb-3"
                        controlId="exampleForm.ControlTextarea1"
                    >
                        <Form.Label id = "password-form">Password</Form.Label>
                        <Form.Control
                            type="password"
                            placeholder="!.LkMn87/"
                            onChange={(e) => setPassword(e.target.value)} 
                        />
                    </Form.Group>
                </Form>
            </Modal.Body>

            <Modal.Footer id = "modal-footer">
                <Button variant="primary" onClick={() => handleLogin()}>Login</Button>
                <Button variant="secondary" onClick={() => handleClose()}>Close</Button>
            </Modal.Footer>
                
        </Modal>

    );

}

export default ModalLogin;