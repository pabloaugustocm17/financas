import Modal from 'react-bootstrap/Modal';
import Button from 'react-bootstrap/Button';
import "./ModalLogin.css";
import LoginService from '../service/LoginService'

function loadBd(){
    LoginService.loadBD();
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
                <Modal.Title id = "modal-title">Modal title</Modal.Title>
            </Modal.Header>

            <Modal.Body id = "modal-body">
                <p id = "modal-body-text">Modal body text goes here.</p>
            </Modal.Body>

            <Modal.Footer id = "modal-footer">
                <Button variant="primary" >Load BD</Button>
                <Button variant="secondary" onClick={props.onHide}>Close</Button>
            </Modal.Footer>
                
        </Modal>

    );

}

export default ModalLogin;