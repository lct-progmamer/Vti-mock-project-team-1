/* eslint-disable */
import axios from "axios";
import React, { useEffect, useState } from "react";
import Carousel from "react-elastic-carousel";
import {useParams} from "react-router-dom";
import Api from "../../api/ctQuyenGopApi";

const QGbyChuyenKhoan = () => {
    
    
    let {id} = useParams();
    
    const [NganHang , setNganHang] = useState([]);
    const [tenChuongTrinh , setTenChuongTrinh] = useState("");
    const [SoTk , setSoTk] = useState("");
    const [statusCopy , setStatusCopy] = useState("");
  
    useEffect(() => {
        // console.log(id);
        axios.get(`${Api.url}/${3}`)
            .then(res => {
                setNganHang(res.data.nganHangs);
                setTenChuongTrinh(res.data.nganHangs[0].tenChuongTrinh);
               
            })
            .catch(res => console.log(res.data))
    }, [NganHang])
   
    const GenSoTk = (id) => {
        NganHang?.map(items => {
            if(items.id == id)
            {
                setSoTk(items.so_tk);
               
            }
        });
    }


    return(

        <>
            <h2>{tenChuongTrinh}</h2>
            <h5>
                Lựa Chọn Ngân Hàng
            </h5>
            <div>
                {
                    NganHang?.map(items => {
                        return (
                            <figure>
                                <img src={items.image} alt={items.name} style={{width:"100%"}} onClick={() => GenSoTk(items.id)} key={items.id}/>
                                <figcaption>{items.name}</figcaption>
                            </figure>

                        );
                    })
                }
            </div>
            <h4>
                Bạn vui lòng chuyển khoản tới số tài khoản sau để chương trình có thể nhận được tấm lòng của bạn
            </h4>
            <h3>
                {SoTk}
            </h3>
            <div>
                <CopyToClipboard>
                    <button className="btn btn-success">Copy</button>
                </CopyToClipboard>
                <button className="btn btn-primary">Quay Lại</button>
            </div>
        </>


    );
}

export default QGbyChuyenKhoan;