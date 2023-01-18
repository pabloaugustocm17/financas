import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "./ModalLogin.css";
import realizeLogin from '../service/LoginService';
import React, {useState} from 'react';

function login(email, password){

    console.log('email (Modal) -> ' + email);

    const requestLogin = realizeLogin(email, password);

    if(requestLogin !== '200'){
       
    }
}


const ModalLogin = (props) => {

    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[errorMessage, setErrorMessage] = useState("");

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
                        <p id= "error-area">{errorMessage}</p>
                    </Form.Group>
                </Form>
            </Modal.Body>

            <Modal.Footer id = "modal-footer">
                <Button variant="primary" type="submit" onClick={() => login(email, password, errorMessage)}>Login</Button>
                <Button variant="secondary" onClick={props.onHide}>Close</Button>
            </Modal.Footer>
                
        </Modal>

    );

}

export default ModalLogin;