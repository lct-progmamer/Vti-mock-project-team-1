
import React from "react";
import { useState , useEffect } from "react";
import Axios from "axios";
import "./CtQuyenGopCss.scss";

const CtQuyenGop = (props) => {
    


    const [QuyenGop, setQuyenGop] = useState();

    useEffect(() => {
       Axios.get('http://localhost:8080/api/v1/ctquyengops')
       .then((res) => {
           setQuyenGop(res.data);
           console.log(res.data);
        })
       .catch((res) => console.log(res));
    }, [])
    
    
    
    return (
        
        <>
            
            <div className="container">
                <div className="row"><img src="" alt="logo" /></div>
               <div className="row">
                {
                    QuyenGop?.map((items , index) => {
                        return <div className="col-4 mb-5 " key={index}><img width="250" height="250"  src={items.images[0].url} alt="" /></div>
                    }) 
                }
               </div>
               <div className="row"></div>
            </div>
        </>
        
    );
}

export default CtQuyenGop;