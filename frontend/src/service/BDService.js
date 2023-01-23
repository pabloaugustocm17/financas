import axios from 'axios';

const PAGE_URL = "http://localhost:8080/"

const LoadBD = () =>{

    return  axios.request(PAGE_URL + "loadBD");
}

export default LoadBD;