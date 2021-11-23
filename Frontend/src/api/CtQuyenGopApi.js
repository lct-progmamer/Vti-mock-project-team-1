import Api from './Api';

const url = "/ctquyengops";

const serverUrl = "http://127.0.0.1:8887";


const getAll = () => {
    return Api.get(`${url}`);
}



const api = { getAll , url , serverUrl};
export default api;