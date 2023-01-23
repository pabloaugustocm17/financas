import axios from 'axios';

const PAGE_URL = "http://localhost:8080/"

const RealizeLogin = async (email, password) => {

    return axios.post(PAGE_URL + "login", {
        "email" : email,
        "password" : password
    })
    .then((response) => {
        return response.data;
    })

}

export default RealizeLogin;

