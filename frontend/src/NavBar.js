import './NavBar.css';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';

const NavBar = () => {
    return (
      <Container id = "container-nav-bar">
          <Row>
            <Col sm={4} id="col-home">
                <a href = "#" id="text-pattern">Home</a>
            </Col>
            <Col sm={4} id = "col-details">
                <a href = "#" id="text-pattern">Details</a>
            </Col>
            <Col sm={4} id = "col-login">
                <a href = "#" id="text-pattern">Login</a>
            </Col>
          </Row>
       </Container>
    );
}

export default NavBar;