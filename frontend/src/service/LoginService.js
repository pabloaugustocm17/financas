import axios from 'axios';
import { useState } from 'react';

const PAGE_URL = "http://localhost:8080/"

const LoginService = () =>{

    const [requestMessage, setRequestMessage] = useState("");

    const loadBD = () => {
        return axios.request(PAGE_URL + "loadBD");
    }

    const realizeLogin = (email, password) => {

        axios.post(PAGE_URL + "login", {
            "email" : email,
            "password" : password
        })
        .then((response) => {

            setRequestMessage(response.data);
        
        })

        console.log(requestMessage);

        return requestMessage;

    }

}
    
    

export default LoginService