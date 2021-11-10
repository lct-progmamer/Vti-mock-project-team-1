import { combineReducers } from "redux";
import ctQuyenGop from "./CtQuyenGopReducer";
import sidebar from "./sidebarReducers";
import layout from "./layoutReducer";
import theme from "./themeReducer";
import UserLoginInfo from "./UserLoginInfoReducers";

import { reducer as toastr } from "react-redux-toastr";

export default combineReducers({
    sidebar,
    layout,
    theme,
    toastr,
    UserLoginInfo,
    ctQuyenGop

});