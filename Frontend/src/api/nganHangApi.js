import Api from "./Api";
import Axios from "axios";
const url = "http://localhost:8080/api/v1/nganhangs";

const getAll = () => {
    return Axios.get(`${url}`);
}

const getById = (Id) => {
    return Api.get(`${url}/${Id}`);
}

const api = { getAll, getById, url };
export default api;