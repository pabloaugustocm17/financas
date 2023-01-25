import './NavBar.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import ModalLogin from '../modal/ModalLogin';
import React, { useState } from 'react';

const NavBar = () => {

    const [modalShow, setModalShow] = useState(false);

    return (
        <div className='NavBar'>
            <Container>
                <Row>
                    <Col sm={4} id="col-pattern">
                        <a href = "#" id="text-pattern">Home</a>
                    </Col>
                    <Col sm={4} id = "col-pattern">
                        <a href = "#" id="text-pattern">Details</a>
                    </Col>
                    <Col sm={4} id = "col-pattern">
                        <a id="text-pattern" href="#" onClick={() => setModalShow(true)}>Login</a>
                    </Col>
                </Row>
            </Container>

            <ModalLogin
                show = {modalShow}
                onHide = {() => setModalShow(false)}
            >
            </ModalLogin>    
            
        </div>
        
    );
}

export default NavBar;