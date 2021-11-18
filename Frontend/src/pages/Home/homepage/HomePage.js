
import React from "react";

import ListCtQuyenGops from "../listctquyengop/ListCtQuyenGops";
import "./HomePage.scss";
const HomePage = () => {


    
    return (

        <>
            <div className="container">
              
                <div className="row">
                    <h3 className="h3"> Các chương trình Quyên góp</h3>
                </div>


                <div className="row">
                    <ListCtQuyenGops/>
                </div>




            </div>
        </>

    );



}




export default HomePage;
