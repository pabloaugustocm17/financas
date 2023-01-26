import { Col, Container, Row } from "react-bootstrap";
import './Contents.css';

const Details = () =>{

    const text = "This page is made by Pablo Magalhães";

    return (<div className = "Details">

        <Container>
            <Row>
                <Col sm = {12} md = {12} lg = {12} id = "col-text-details">
                    <p id = "text-details">{text}</p>
                </Col>
            </Row>
        </Container>

    </div>

    );

}

export default Details;