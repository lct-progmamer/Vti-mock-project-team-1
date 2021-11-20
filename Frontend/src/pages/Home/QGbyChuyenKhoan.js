/* eslint-disable */
import axios from "axios";
import React, { useEffect, useState ,useRef } from "react";
import {Link, useParams} from "react-router-dom";
import api from "../../api/CtQuyenGopApi";
import "./ChuyenKhoanCss.scss";
import { toastr } from "react-redux-toastr";
import {
    Button,
    Card,
    CardBody,
    Col,
    Container,
    Row,
    Modal,
    ModalBody,
    ModalFooter,
    ModalHeader,
} from "reactstrap";
import Header from "./HeaderAndFooter/Header";
import Footer from "./HeaderAndFooter/Footer";


const QGbyChuyenKhoan = () => {
    
    
    let {id} = useParams();
    
    const [NganHang , setNganHang] = useState([]);
    const [tenChuongTrinh , setTenChuongTrinh] = useState("");
    const [SoTk , setSoTk] = useState("**************");
    const textAreaRef = useRef(null); 
  
    useEffect(() => {
        console.log(id);
        axios.get(`http://localhost:8080/api/v1/ctquyengops/${id}`)
            .then(res => {
                setNganHang(res.data.nganHangs);
                setTenChuongTrinh(res.data.nganHangs[0].tenChuongTrinh);
            })
            .catch(res => console.log(res.data))
    }, [])
   
    const GenSoTk = (id) => {
        NganHang?.map(items => {
            if(items.id == id)
            {
                setSoTk(items.so_tk);
            }
        });
    }

    function copyToClipboard(e) {
        textAreaRef.current.select();
        document.execCommand('copy');
        // This is just personal preference.
        // I prefer to not show the the whole text area selected.
        e.target.focus();
        showSucessNotification("" , "Copied");
      };

      const showSucessNotification = (title, message) => {
        const options = {
          timeOut: 1500,
          showCloseButton: false,
          progressBar: false,
          position: "top-right"
        };
    
        // show notification
        toastr.success(title, message, options);
      }



    return(

        <>
            <Header />
            <Container className="container mt-5">
                <h2 className="donation_title mb-5">{tenChuongTrinh}</h2>
                <h5 className="bank_title">
                    Lựa Chọn Ngân Hàng
                </h5>
                <Row>
                    {
                    
                        NganHang?.map(items => {
                            return (
                                <Col xs="3">
                                    <figure key={items.id}>
                                        <img className="image_bank" src={`http://127.0.0.1:8887/${items.image}`} alt={items.name} width="150" height="150" onClick={() => GenSoTk(items.id)} key={items.id}/>
                                        <figcaption className="bank_name">{items.name}</figcaption>
                                    </figure>
                                </Col>
                            );
                        })
                    }  
                </Row>
                <h4>
                    Bạn vui lòng chuyển khoản tới số tài khoản sau để chương trình có thể nhận được tấm lòng của bạn
                </h4>
                <form>
                    <input className="pay_account" type="text" ref={textAreaRef} value={SoTk}/>
                </form>
                <div className="btn">
                    {
                         document.queryCommandSupported('copy') &&
                         <Button className="btn-copy" color="success" onClick={copyToClipboard}>Copy</Button>

                    }
                    
                    
                    <Link to={`/detail/${id}`}><Button className="btn-back" color="primary">Quay Lại</Button></Link>
               </div>
            </Container>
            <Footer />
        </>


    );
}

export default QGbyChuyenKhoan;