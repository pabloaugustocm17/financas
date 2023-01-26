import { Container, Row } from "react-bootstrap";
import Details from "./Details";
import Home from "./Home";

const Content= () =>{

    return (
        <div className = "Content">

            <Container>
                <Row>
                    <Home/> 
                </Row>
                <Row>
                    <Details/>
                </Row>
            </Container>

        </div>
        
    );

}

export default Content;