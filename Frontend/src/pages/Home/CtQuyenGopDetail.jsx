import React from "react";
import axios from "axios";
import { useEffect, useState } from "react";
import Api from "../../api/ctQuyenGopApi";
import Carousel from "react-elastic-carousel";
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


const CtQuyenGopDetail = (props) => {

    const [QuyenGop, setQuyenGop] = useState({});

    useEffect(() => {
        axios.get(`${Api.url}/3`)
            .then(res => setQuyenGop(res.data))
            .catch(res => console.log(res.data))
    }, [])



    return (

        <>
            <div>
                <h3>{QuyenGop.name}</h3>
                <h5>Thời gian bắt đầu : {QuyenGop.dayStart}/{QuyenGop.monthStart}/{QuyenGop.yearStart}</h5>

            </div>
            <hr />
            <h5>Hình ảnh câu chuyện : </h5><br />
            <Carousel>
                {
                    QuyenGop.images?.map((img, index) => {
                        return <img src={img.url} alt="1" className="img" key={index} />
                    })
                }
            </Carousel>
            <hr />
            <>
                <Row className="storyTuThien">
                    <Col xs="7">

                        <fieldset>
                            <legend>Câu Chuyện : </legend>
                            <p>{QuyenGop.discription}</p>
                        </fieldset>

                    </Col>
                    <Col xs="4">
                        <div className="card-dongtien">
                            <h4 className="title_dongTien">Thực hiện Quyên Góp</h4>
                            <Button color="primary" className="button_dongTien">Hướng Dẫn Quyên Góp</Button>
                            <Button color="success" className="button_dongTien">Quyên Góp Ngay</Button>
                        </div>

                        <div className="card-dongtien">
                            
                        </div>
                    </Col>
                </Row>
            </>

        </>


    );


}
export default CtQuyenGopDetail;