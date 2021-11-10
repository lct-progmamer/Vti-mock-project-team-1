import * as types from "../constants";
import ctQuyenGopApi from "../../api/ctQuyenGopApi";
import { getAllCtQuyenGopSuccess, getAllCtQuyenGopFail } from "../actions/CtQuyenGopActions";


const CtQuyengopsRequest = () => {

    return ((dispatch) => {
        ctQuyenGopApi.getAll().then(
            res => dispatch(getAllCtQuyenGopSuccess(res.data))
        ).catch(
            res => dispatch(getAllCtQuyenGopFail("Something wrent wrong!!!"))
        );
    })
}


const request = { CtQuyengopsRequest };
export default request;