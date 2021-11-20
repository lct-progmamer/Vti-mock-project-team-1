
import React from "react";
import Footer from "../HeaderAndFooter/Footer";
import Header from "../HeaderAndFooter/Header";

import ListCtQuyenGops from "../listctquyengop/ListCtQuyenGops";
import "./HomePage.scss";
const HomePage = () => {


    
    return (

        <>
            <Header />
            <div className="container">
                
                <div className="row">
                    
                    <h3 className="h3"> Các chương trình Quyên góp</h3>
                </div>
                <div className="row">
                    <ListCtQuyenGops/>
            
                </div> 
                
            </div>
            <Footer />   
            
        </>

    );



}




export default HomePage;
