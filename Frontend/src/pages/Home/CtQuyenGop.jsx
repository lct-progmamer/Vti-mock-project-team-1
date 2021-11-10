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
import React from "react";
import { useState, useEffect } from "react";
import "./CtQuyenGopCss.scss";
import { useSelector, useDispatch } from 'react-redux';
import ctQuyenGopApi from "../../api/ctQuyenGopApi";
import { getAllCtQuyenGopSuccess, getAllCtQuyenGopFail } from "../../redux/actions/CtQuyenGopActions";
import CtQuyenGopItem from "./CtQuyenGopItem";


const CtQuyenGop = () => {



    const dispatch = useDispatch();
    const quyengops = useSelector(state => state.ctQuyenGop.ctQuyenGops);


    useEffect(() => {
        ctQuyenGopApi.getAll()
            .then(res => dispatch(getAllCtQuyenGopSuccess(res.data)))
            .catch(res => dispatch(getAllCtQuyenGopFail("Some thing wrent wrong!!!")));
    }, [])




    return (

        <>
            <div className="row">
                {
                    quyengops?.map(item => {
                        return <CtQuyenGopItem name={item.name} discription={item.discription}
                         images={item.images} tinhtrang={item.tinhTrang} key={item.id}/>
                    })
                }
            </div>
            
        </>

    );
}

export default CtQuyenGop;

