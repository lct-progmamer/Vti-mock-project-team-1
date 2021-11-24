const setRememberMe = (isRememberMe) => {
    localStorage.setItem('isRememberMe', isRememberMe);
};

const isRememberMe = () => {

    if (localStorage.getItem('isRememberMe') === null || localStorage.getItem('isRememberMe') === undefined) {
        return true;
    }

    // convert string to boolean
    return JSON.parse(localStorage.getItem('isRememberMe'));
};

const setItem = (key, value) => {
    if (isRememberMe()) {
        localStorage.setItem(key, value);
    } else {
        sessionStorage.setItem(key, value);
    }
}

const getItem = (key) => {
    if (isRememberMe()) {
        return localStorage.getItem(key);
    } else {
        return sessionStorage.getItem(key);
    }
}

const setToken = (token) => {
    setItem('token', token);
};

const getToken = () => {
    return getItem('token');
};

const setUserInfo = (userName, email, sdt , firstName, lastName, role, status) => {
    setItem('userName', userName);
    setItem('email', email);
    setItem('sdt',sdt);
    setItem('firstName', firstName);
    setItem('lastName', lastName);
    setItem('role', role);
    setItem('status', status);
}

const RemoveInforUser = () =>{
    if(isRememberMe()){
        setRememberMe(false);
        localStorage.removeItem('token');
        localStorage.removeItem('userName');
        localStorage.removeItem('email');
        localStorage.removeItem('sdt');
        localStorage.removeItem('firstName');
        localStorage.removeItem('lastName');
        localStorage.removeItem('role');
        localStorage.removeItem('status');
    }
    else
    {
        sessionStorage.removeItem('token');
        sessionStorage.removeItem('userName');
        sessionStorage.removeItem('email');
        sessionStorage.removeItem('sdt');
        sessionStorage.removeItem('firstName');
        sessionStorage.removeItem('lastName');
        sessionStorage.removeItem('role');
        sessionStorage.removeItem('status');
    }
}




const getUserInfo = () => {
    return {
        'userName': getItem('userName'),
        'email': getItem('email'),
        'sdt' : getItem('sdt'),
        'firstName': getItem('firstName'),
        'lastName': getItem('lastName'),
        'role': getItem('role'),
        'status': getItem('status')
    };
}

// export
const storage = { isRememberMe,RemoveInforUser, setRememberMe, setToken, getToken, setUserInfo, getUserInfo }
export default storage;