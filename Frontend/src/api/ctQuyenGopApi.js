import Api from './Api';

const url = "/ctquyengops";
const serverUrl = "http://127.0.0.1:8887";


const getCtQuyenGop = () => {
    return Api.get(`${url}`);
};

const api = { getCtQuyenGop , serverUrl }
export default api;