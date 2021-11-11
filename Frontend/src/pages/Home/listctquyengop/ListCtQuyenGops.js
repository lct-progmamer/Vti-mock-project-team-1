
import React from "react";
import "./ListItemCtQuyenGops.scss";
function ListCtQuyenGops(props) {

    const value = props.value;
    return (

        <div className="listCtquyengop">

            <img className="img" src={value.images[0].url} alt="" />
            <div className="b">
                <b > {value.name}</b>
            </div>


        </div>


    )
}


export default ListCtQuyenGops;
