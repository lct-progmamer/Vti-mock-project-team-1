import * as types from "../constants";

export function setUserLoginInfo(userName, email,sdt, firstName, lastName, role, status) {
  return {
    type: types.USER_LOGIN_INFO,
    payload: {
      "userName": userName,
      "email": email,
      "sdt" : sdt,
      "firstName": firstName,
      "lastName": lastName,
      "role": role,
      "status": status
    }
  };
}

export function setTokenInfo(token) {
  return {
    type: types.TOKEN_INFO,
    payload: token
  };
}