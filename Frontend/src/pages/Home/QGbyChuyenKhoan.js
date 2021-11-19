/* eslint-disable */
import axios from "axios";
import React, { useEffect, useState ,useRef } from "react";
import {Link, useParams} from "react-router-dom";
import api from "../../api/ctQuyenGopApi";
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


const QGbyChuyenKhoan = () => {
    
    
    let {id} = useParams();
    
    const [NganHang , setNganHang] = useState([]);
    const [tenChuongTrinh , setTenChuongTrinh] = useState("");
    const [SoTk , setSoTk] = useState("**************");
    const textAreaRef = useRef(null); 
  
    useEffect(() => {
        // console.log(id);
        axios.get(`${api.url}/${1}`)
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
            <Container className="container">
                <h2 className="donation_title">{tenChuongTrinh}</h2>
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
                    
                    
                    <Link to={`/ctquyengops/${id}`}><Button className="btn-back" color="primary">Quay Lại</Button></Link>
               </div>
            </Container>
        </>


    );
}

export default QGbyChuyenKhoan;