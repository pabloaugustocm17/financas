import axios from 'axios';

const PAGE_URL = "http://localhost:8080/"

export const RealizeLogin = async (email, password) => {

    return axios.post(PAGE_URL + 'login', {
        "email" : email,
        "password" : password
    })
    .then((response) => {
        return response.data;
    });

}

export const RealizeRegistration  = async(name, email, password, birth_date) => {

    return axios.post(PAGE_URL + 'registerNewUser', {
        'name': name,
        'email' : email,
        'password' : password,
        'birth_date' : birth_date
    })
    .then((response) => {
        return response.data;
    });
}


