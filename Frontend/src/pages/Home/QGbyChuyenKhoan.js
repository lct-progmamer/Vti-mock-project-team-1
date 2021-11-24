/* eslint-disable */
import axios from "axios";
import React, { useEffect, useState ,useRef } from "react";
import {Link, useParams} from "react-router-dom";
import api from "../../api/CtQuyenGopApi";
import "./ChuyenKhoanCss.scss";
import { toastr } from "react-redux-toastr";
import { Formik, FastField, Form  } from 'formik';
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
import * as Yup from 'yup';
import FormGroup from "reactstrap/lib/FormGroup";
import { ReactstrapInput } from "reactstrap-formik";


const QGbyChuyenKhoan = () => {
    
    
    let {id} = useParams();
    
    const [NganHang , setNganHang] = useState([]);
    const [tenChuongTrinh , setTenChuongTrinh] = useState("");
    const [SoTk , setSoTk] = useState();
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
    const showErrorNotification = (title, message) => {
        const options = {
          timeOut: 3500,
          showCloseButton: false,
          progressBar: false,
          position: "top-right"
        };
    
        // show notification
        toastr.error(title, message, options);
    }

    return(

        <>
            <Header />
            <Container className="container mt-5">
                <h2 className="donation_title mb-5">Chương Trình : {tenChuongTrinh}</h2>
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

                <Formik
                    initialValues={
                        {
                            firstName :'',
                            lastName :'',
                            phoneNumber : '',
                            email : '',
                            soTien : 1000
                        }
                    }
                    validationSchema = {
                        Yup.object({
                            firstName: Yup.string()
                                .min(2 , 'Ít nhất chứa 2 kí tự')
                                .required('Thông tin này là bắt buộc'),
                            lastName : Yup.string()
                                .min(2 , 'ít nhất phải 2 kí tự trở lên')
                                .required('Thông tin này là bắt buộc'),
                            phoneNumber : Yup.string()
                                .required('Thông tin này là bắt buộc')
                                .matches(/^((\\+[1-9]{1,4}[ \\-]*)|(\\([0-9]{2,3}\\)[ \\-]*)|([0-9]{2,4})[ \\-]*)*?[0-9]{3,4}?[ \\-]*[0-9]{3,4}?$/ , 'Đây không phải là số điện thoại'),
                            email : Yup.string()
                                .email('Đây không phải Email')
                                .required('Thông tin này là bắt buộc'),
                            soTien : Yup.number()
                                .required('Hãy nhập số tiền bạn muốn quyên hóp')
                                .min(1000 , 'Số tiền phải lớn hơn 1000 đồng')
            
                        })
                    }
                    onSubmit = { (values) => {
                            if(SoTk == null || SoTk == undefined)
                            {   showErrorNotification("","Hãy Chọn Ngân Hàng Bạn Muốn Sủ Dụng");
                                
                            }
                            else{
                                showSucessNotification(`Bạn đã quyên góp thành công ${values.soTien} VNĐ` );
                                
                            }
                            resetForm();   
                        }
                    }
                >
                    {({ isSubmitting }) => (
                        <Card>
                            <CardBody>
                            <div className="m-sm-4">
                                <Form>
                                    <FormGroup>
                                        {
                                            SoTk ? <h4 className="key_pay">
                                                Bạn vui lòng chuyển khoản  với cú pháp sau
                                                " {`CTQG_${id}`} " đến số tài khoản {SoTk}</h4> : null
                                        }   
                                    </FormGroup>
                                    <FormGroup>
                                        <FastField
                                            label="Nhập họ và tên đệm"
                                            type="text"
                                            bsSize="lg"
                                            name="firstName"
                                            placeholder="Họ và Tên đệm"
                                            component={ReactstrapInput}
                                        />
                                    </FormGroup>
                                    <FormGroup>
                                        <FastField
                                            label="Nhập Tên"
                                            type="text"
                                            bsSize="lg"
                                            name="lastName"
                                            placeholder="Tên"
                                            component={ReactstrapInput}
                                        />
                                    </FormGroup>
                                    <FormGroup>
                                        <FastField
                                            label="Nhập Số Điện Thoại"
                                            type="text"
                                            bsSize="lg"
                                            name="phoneNumber"
                                            placeholder="SDT"
                                            component={ReactstrapInput}
                                        />
                                    </FormGroup>
                                    <FormGroup>
                                        <FastField
                                            label="Nhập Email"
                                            type="Email"
                                            bsSize="lg"
                                            name="email"
                                            placeholder="email"
                                            component={ReactstrapInput}
                                        />
                                    </FormGroup>
                                    <FormGroup>
                                        <FastField
                                            label="Nhập Số Tiền Quyên Góp"
                                            type="number"
                                            bsSize="lg"
                                            name="soTien"
                                            placeholder="Số Tiền"
                                            component={ReactstrapInput}
                                        />
                                    </FormGroup>

                                    <div className="text-center mt-3">
                                        <Button type='submit' color="primary" size="lg">
                                            Quyên Góp Ngay
                                        </Button>
                                    </div>
                            </Form>
                            </div>
                            </CardBody>
                        </Card>





                    )}

                </Formik>    
                <div>    
                    <Link to={`/detail/${id}`}><Button className="btn-back" color="primary">Quay Lại</Button></Link>
               </div>
            </Container>
            <Footer />
        </>


    );
}

export default QGbyChuyenKhoan;