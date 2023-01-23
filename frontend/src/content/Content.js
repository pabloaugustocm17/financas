import { Container, Row } from "react-bootstrap";
import Home from "./Home";

const Content= () =>{

    return (
        <div className="Content">

            <Container>
                <Row>
                    <Home/>        
                </Row>
            </Container>

        </div>
        
    );

}

export default Content;