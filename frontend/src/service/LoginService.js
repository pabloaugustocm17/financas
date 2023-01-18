import axios from 'axios';

const PAGE_URL = "http://localhost:8080/"

class LoginService{
    
    loadBD(){
        return axios.request(PAGE_URL + "loadBD");
    }

    realizeLogin(props){
        return axios.request(PAGE_URL + "login");
    }
    
}

export default new LoginService()