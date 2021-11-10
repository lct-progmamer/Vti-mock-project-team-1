import * as type from "../constants"

const initialState = {
    ctQuyenGops: []
}

export default function ctQuyenGopsReducer(state = initialState, actions) {
    switch (actions.type) {

        case type.Get_list_Ct_Quyen_Gop_Success:
            return {
                ...state,
                ctQuyenGops: actions.payload
            }
        case type.Get_list_Ct_Quyen_Gop_Fail:
            return {
                ...state,
                ctQuyenGops: actions.payload
            }
        default:
            return state;

    }
}