import './NavBar.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

const NavBar = () => {
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
                        <a href = "#" id="text-pattern">Login</a>
                    </Col>
                </Row>
            </Container>
        </div>
    );
}

export default NavBar;