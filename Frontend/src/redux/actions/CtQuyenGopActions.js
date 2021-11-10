import * as types from "../constants";


export const getAllCtQuyenGopSuccess = (payload) => {
    return {
        type: types.Get_list_Ct_Quyen_Gop_Success,
        payload
    }
}

export const getAllCtQuyenGopFail = (payload) => {
    return {
        type: types.Get_list_Ct_Quyen_Gop_Fail,
        payload
    }
}