import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "./ModalLogin.css";
import RealizeLogin from '../service/RealizeLogin';
import LoadBD from '../service/BDService';
import React, {useState} from 'react';

async function login(email, password){

    const response = await RealizeLogin(email, password);

    return response;

}

const ModalLogin = (props) => {

    const[firstLogin, setFirstLogin] = useState(false);
    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[errorMessage, setErrorMessage] = useState("");

    const handleLogin = async () =>{
        
        const response = await login(email,password);

        //Use to tests
        if(firstLogin === false){
            const bd_load = LoadBD();
            console.log(bd_load);
            setFirstLogin(true);
        }

        if(response !== 200){
            setErrorMessage(response);
        }else{
            setErrorMessage('');
        }
    }

    const handleClose = () => {

        setErrorMessage('');
        setEmail('');
        setPassword('');
        props.onHide();

    }

    return (
        
        <div className='ModalLogin'>
            <Modal
            {...props}
            size = 'md'
            aria-labelledby="contained-modal-title-vcenter"
            dialogClassName = "modal-login-dialog"
            contentClassName='modal-login-content'
            id = "modal"
            centered
            >
                <Modal.Header
                id = "modal-header">
                    <Modal.Title id = "modal-title">Login</Modal.Title>
                </Modal.Header>

                <Modal.Body id = "modal-body">
                    <p id= "error-area">{errorMessage}</p>
                    <Form id = "form-body" >
                        <Form.Group id = "modal-form-group">
                            <Form.Label id = "email-adress-form">Email address</Form.Label>
                            <Form.Control
                                id = "form-control-email"
                                type="email"
                                placeholder="name@example.com"  
                                onChange={(e) => setEmail(e.target.value)}    
                            />
                        </Form.Group>
                        <Form.Group id = "modal-form-group">
                            <Form.Label id = "password-form">Password</Form.Label>
                            <Form.Control
                                id = "form-control-password"
                                type="password"
                                placeholder="!.LkMn87/"
                                onChange={(e) => setPassword(e.target.value)} 
                            />
                        </Form.Group>
                    </Form>
                    <label id= "register-area">Register</label>
                </Modal.Body>

                <Modal.Footer id = "modal-footer">
                    <Button id = "button-login" onClick={() => handleLogin()}>Login</Button>
                    <Button id = "button-close" onClick={() => handleClose()}>Close</Button>
                </Modal.Footer>
                    
            </Modal>
        </div>

    );

}

export default ModalLogin;