import { Col, Container, Row } from "react-bootstrap";
import './Contents.css';
import img from '../resources/img.png'

const Home = () =>{

    const text = ' This is a page created for study purposes only, showing some application knowledge of React and SpringBoot';

    return (
        <div className = "Home">

            <Container>
                <Row>
                    <Col sm = {12} md = {8} lg = {6} id = "col-img-home">
                        {/* Image */}
                        <img src={img} alt = 'img'/>
                    </Col>

                    <Col sm = {12} lg = {6} md = {4} id = "col-text-home">
                        {/* Informations about home */}
                        <p id= "text-home">{text}</p>
                    </Col>
                </Row>
            </Container>

        </div>
    );

}

export default Home;