import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import api from "../../api/CtQuyenGopApi";
import Carousel from 'nuka-carousel';
import {Link , useParams} from "react-router-dom";
import "./CtQuyenGopCss.scss";
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
import Footer from "./HeaderAndFooter/Footer";
import Header from "./HeaderAndFooter/Header";

const CtQuyenGopDetail = () => {

    const [QuyenGop, setQuyenGop] = useState({});
    const [others , setOthers] = useState([]);
    const [IsShow, setisShow] = useState(false);
    let {id} = useParams();

    useEffect(() => {
        
        axios.get(`http://localhost:8080/api/v1/ctquyengops/${id}`)
            .then(res => setQuyenGop(res.data))
            .catch(res => console.log(res.data))

        axios.get(`http://localhost:8080/api/v1/ctquyengops`)
            .then(res => setOthers(res.data))
            .catch(res => console.log(res));
        

    }, [id])



    const OpenModalQyenGop = () =>{
        setisShow(!IsShow);
    }


    return (

        <>
            <Header />
            <Container>
            <div className="mt-5">
                <h3 className="mb-5">{QuyenGop.name}</h3>
                <h5>Thời gian bắt đầu : {QuyenGop.dayStart}/{QuyenGop.monthStart}/{QuyenGop.yearStart}</h5>

            </div>
            <hr />
            <h5>Hình ảnh câu chuyện : </h5><br />
            <Carousel animation="zoom" autoplay="true" autoplayInterval="1000">
                {
                    QuyenGop.images?.map((img , index) => {
                        return <img key={index} width="278" height="400" src={`${api.serverUrl}/${img.name}`} alt={img.name}/>
                    })
                }
            </Carousel>
            <hr />
            <>
                <Row className="storyTuThien">
                    <Col xs="7">

                        <div>
                            <h4>Tình trạng chương trình </h4>
                            <div className="progress">
                                <div className="progress-bar progress-bar-striped progress-bar-animated bg-success" role="progressbar" aria-valuenow="75" aria-valuemin="0" aria-valuemax="100" style={{ width: `${QuyenGop.tinhTrang}%` }}>{QuyenGop.tinhTrang}%</div>
                            </div>
                            <div className="tongTienDong">
                                <h4>Số tiền quyên góp : {QuyenGop.tongTien} VND</h4>
                            </div>
                        </div>
                        <fieldset>
                            <h4><legend>Tóm Tắt Hoàn Cảnh : </legend></h4>
                            <p>{QuyenGop.discription}</p>
                        </fieldset>

                    </Col>
                    <Col xs="4">
                        <div className="card-dongtien1">
                            <h4 className="title_dongTien">Thực hiện Quyên Góp</h4>
                            <Button color="primary" className="button_dongTien">Hướng Dẫn Quyên Góp</Button>
                            <Button color="success" className="button_dongTien" onClick={() => OpenModalQyenGop()}>Quyên Góp Ngay</Button>
                        </div>

                        <div className="card-dongtien">
                            {
                                others?.map((items) => {
                                    if(items.id != id)
                                    {
                                        return (
                                            <Card className="other">
                                                <CardBody width="100">
                                                    <Link to={`/detail/${items.id}`}>
                                                        <img width="200" height="100" src={`${api.serverUrl}/${items.images[0].name}`}  alt={items.images[0].name}/>
                                                        <h6 className="otherName">{items.name.substring(0,30)}...</h6>
                                                    </Link>
                                                </CardBody>
                                            </Card>

                                        );
                                    }
                                })
                            }
                        </div>
                    </Col>
                </Row>
                <div>    
                    <Link to={`/`}><Button className="btn-back" color="primary">Quay Lại</Button></Link>
                </div>
            </>
            <Modal isOpen={IsShow} toggle={OpenModalQyenGop} size="lg">
                <ModalHeader>Các Hình Thức Quyên Góp</ModalHeader>
                <ModalBody>
                    <div className="content-modal-QG">
                        <div >
                            <div className="htQG">
                                <img id="img-ht1" height="150" width="250" src="https://poxi.vn/images/huong-dan/vnqrpay.jpg" alt="vnPay" />
                            </div>
                            <div className="htQG">
                                <img id="img-ht2" height="150" width="250" src="http://getplugd.com/blog/content/images/2020/07/paypal.png" alt="paypal" />
                            </div>
                            <div className="htQG">
                                <Link to={`/detail/${QuyenGop.id}/byPay`}><img id="img-ht3" height="150" width="250" src="https://lsvn.vn/uploads/files/1014/5ffe70974e2d2.jpg" alt="chuyenKhoan" /></Link>
                            </div>
                        </div>
                        <span>
                            <img id="banner-QG" src="https://file1.dangcongsan.vn/data/0/images/2021/01/21/phamthanh/1509-cd1b5663-f90f-466c-b191-c08d8c661187.jpg?dpi=150&quality=100&w=680" height="400" width="300" alt="banner" />
                        </span>
                    </div>
                </ModalBody>
                <ModalFooter>
                    <Button color='secondary' onClick={OpenModalQyenGop}>Quay Lại</Button>
                </ModalFooter>
            </Modal>
            </Container>
            <Footer />
        </>


    );


}
export default CtQuyenGopDetail;