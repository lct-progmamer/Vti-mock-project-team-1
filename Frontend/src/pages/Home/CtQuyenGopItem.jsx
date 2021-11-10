
import React from "react";
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


const CtQuyenGopItem = ({ name, images, discription, tinhtrang }) => {

    return (
        <div className="card" style="width: 18rem;">
            <img src="..." className="card-img-top" alt="..."/>
            <div className ="card-body">
                <h5 className ="card-title">{name}</h5>
                <p className ="card-text">{discription.substring(0,100)}...</p>
                <a href="#" className ="btn btn-primary">Xem Chi Tiết</a>
            </div>
        </div>
    );
}

export default CtQuyenGopItem;