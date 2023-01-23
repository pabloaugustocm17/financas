import { Col, Container, Row } from "react-bootstrap";
import './Home.css';

const Home = () =>{

    const text = ' This is a home page';

    return (
        <div className="Home">

            <Container>
                <Row>
                    <Col sm = {12} md = {8} lg = {6} id = "col-img-home">
                        {/* Image sm=12*/}
                        <p id = "img-home" >Img</p>
                    </Col>

                    <Col lg = {6} md = {4} id = "col-text-home">
                        {/* Informations about home */}
                        <p id= "text-home">{text}</p>
                    </Col>
                </Row>
            </Container>

        </div>
    );

}

export default Home;