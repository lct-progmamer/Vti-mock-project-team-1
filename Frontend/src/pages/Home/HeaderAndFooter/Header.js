import React, { useEffect  } from "react";
import { Link , useHistory } from "react-router-dom";
import storage from "../../../Storage/Storage";
import avatar1 from "../../../assets/img/avatars/avatar.jpg";
import UserApi from "../../../api/UserApi";
import { useState } from "react";
import { useSelector} from 'react-redux';
const Header = () =>{

    const history = useHistory();
    
    
    const token = storage.getToken();

    const imageUrl = storage.getUserInfo().avatarUrl;

    const toLogin = () => {
        history.push('/auth/sign-in');
    }

    const toSignIn =  () => {
        history.push('/auth/sign-up');
    }

    const LogOut = () => {
       storage.RemoveInforUser();
       history.push('/');
    }


    const ButtonBeforeLogin = () =>{
        return(
            <div className="text-end">
                <button type="button" className="btn btn-outline-light me-2" onClick={toLogin}>Login</button>
                <button type="button" className="btn btn-warning" onClick={toSignIn}>Sign-up</button>
            </div>
        );
    }

    const ButtonAfterLogin = () =>{
        return(
            <>
            {/*  : */}
                <img src={ imageUrl ? `http://127.0.0.1:8887/${imageUrl}` : avatar1} className="rounded-circle img-responsive mt-2 mr-3"
                  width="40"
                  height="40"/>
                <button type="button" className="btn btn-warning me-2" onClick={LogOut}>Logout</button>
            </>
        );
    }



    return (
        <>
            <header className="p-3 bg-dark">
                <div className="container">
                    <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
                        <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                            <Link to="/" style={{textDecoration:"none"}}><h3 style={{color:"white"}}>VTI</h3></Link>
                        </ul>

                        <form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
                        <input type="search" className="form-control form-control-dark" placeholder="Search..." aria-label="Search" />
                        </form>
                        <>
                        {
                            token ? <ButtonAfterLogin /> : <ButtonBeforeLogin/>
                        }
                        </>
                    </div>
                </div>
            </header>


        </>
    );
}

export default Header;