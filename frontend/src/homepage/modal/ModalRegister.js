import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import { CloseButton } from 'react-bootstrap';
import Form from 'react-bootstrap/Form';
import React, {useState} from 'react';
import { RealizeRegistration } from '../service/RealizeLogin';

async function realizeRegistration(name, email, password, birth_date){

    console.log('Name -> ' + name);
    console.log('Email -> ' + email);
    console.log('Password -> ' + password);
    console.log('Birth date -> ' + birth_date);

    const response = await RealizeRegistration(name, email, password, birth_date);

    return response;
}

const ModalRegister = (props) =>{

    const[name, setName] = useState("");
    const[email, setEmail] = useState("");
    const[password, setPassword] = useState("");
    const[birth_date, setBirth_date] = useState("");
    const[errorMessage, setErrorMessage] = useState("");

    const handleClose = () => {
        props.onHide();
        setEmail('');
        setPassword('');
        setBirth_date(null);
        setName('');
        setErrorMessage('');
    }

    const handleRegister = async () => {
        
        const response = await realizeRegistration(name, email, password, birth_date);

        if(response !== 200){
            setErrorMessage(response);
        }else{
            setErrorMessage('');
        }

    }

    return (

        <div className="ModalRegister">

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
                    id = "modal-header"
                    >
                        <Modal.Title id = "modal-title">Register</Modal.Title>
                        <CloseButton variant='white' onClick={() => handleClose()}></CloseButton>
                    </Modal.Header>

                    <Modal.Body id = "modal-body">
                        <p id= "error-area">{errorMessage}</p>
                        <Form id = "form-body" >
                            <Form.Group id = "modal-form-group">
                                <Form.Label id = "name-form">Name</Form.Label>
                                <Form.Control
                                    id = "form-control-name"
                                    type="name"
                                    placeholder="Jonh Smith"  
                                    onChange={(e) => setName(e.target.value)}    
                                />
                            </Form.Group>
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
                            <Form.Group id = "modal-form-group">
                                <Form.Label id = "birthdate-form">Birth Date</Form.Label>
                                <Form.Control
                                    id = "form-control-birthdate"
                                    type="date"
                                    onChange={(e) => setBirth_date(e.target.value)} 
                                />
                            </Form.Group>
                        </Form>
                    </Modal.Body>

                    <Modal.Footer id = "modal-footer">
                        <Button id = "button-login" onClick={() => handleRegister()} >Register</Button>
                        <Button id = "button-close" onClick={() => handleClose()}>Close</Button>
                    </Modal.Footer>
                        
            </Modal>

        </div>

    );

}

export default ModalRegister;