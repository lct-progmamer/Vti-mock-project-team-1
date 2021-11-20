import Api from './Api';

const url = "/ctquyengops";
const getCtQuyenGop = () => {
    return Api.get(`${url}`);
};

const api = { getCtQuyenGop }
export default api;