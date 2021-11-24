
import React, { useEffect, useState } from "react";
import "./ListItemCtQuyenGops.scss";
import { connect } from "react-redux";
import { getlistCtQuyenGopAction } from '../../../redux/actions/CtQuyenGopAction';
import { selectListCtQuyenGop } from '../../../redux/selectors/CtQuyenGopSelector';
import Carousel from 'nuka-carousel';
import api from "../../../api/CtQuyenGopApi";
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
import { useHistory } from "react-router";
import { idea } from "react-syntax-highlighter/dist/esm/styles/hljs";





function ListCtQuyenGops(props) {



    const getListCtQuyenGops = props.getlistCtQuyenGopAction;
    const data = props.ctquyengops;
    const history = useHistory();


    const [currentPage, setcurrentPage] = useState(1);
    // const [itemsPerPage, setitemsPerPage] = useState(3);
    const itemsPerPage = 3;
    // const [pageNumberLimit, setpageNumberLimit] = useState(3);
    const pageNumberLimit = 3

    const [maxPageNumberLimit, setmaxPageNumberLimit] = useState(3);
    const [minPageNumberLimit, setminPageNumberLimit] = useState(0);


    useEffect(() => {
        getListCtQuyenGops();
    }, [getListCtQuyenGops]);

    const handleClick = (event) => {
        setcurrentPage(Number(event.target.id));
    };

    const pages = [];
    for (let i = 1; i <= Math.ceil(data.length / itemsPerPage); i++) {
        pages.push(i);
    }

    const indexOfLastItem = currentPage * itemsPerPage;
    const indexOfFirstItem = indexOfLastItem - itemsPerPage;
    const currentItems = data.slice(indexOfFirstItem, indexOfLastItem);

    const renderPageNumbers = pages.map((number) => {
        if (number < maxPageNumberLimit + 1 && number > minPageNumberLimit) {
            return (
                <li
                    key={number}
                    id={number}
                    onClick={handleClick}
                    className={currentPage === number ? "active" : null}
                >
                    {number}
                </li>
            );
        } else {
            return null;
        }
    });

    // useEffect(() => {
    //   fetch("https://jsonplaceholder.typicode.com/todos")
    //     .then((response) => response.json())
    //     .then((json) => setData(json));
    // }, []);

    const handleNextbtn = () => {
        setcurrentPage(currentPage + 1);

        if (currentPage + 1 > maxPageNumberLimit) {
            setmaxPageNumberLimit(maxPageNumberLimit + pageNumberLimit);
            setminPageNumberLimit(minPageNumberLimit + pageNumberLimit);
        }
    };

    const handlePrevbtn = () => {
        setcurrentPage(currentPage - 1);

        if ((currentPage - 1) % pageNumberLimit === 0) {
            setmaxPageNumberLimit(maxPageNumberLimit - pageNumberLimit);
            setminPageNumberLimit(minPageNumberLimit - pageNumberLimit);
        }
    };

    let pageIncrementBtn = null;
    if (pages.length > maxPageNumberLimit) {
        pageIncrementBtn = <li onClick={handleNextbtn}> &hellip; </li>;
    }

    let pageDecrementBtn = null;
    if (minPageNumberLimit >= 1) {
        pageDecrementBtn = <li onClick={handlePrevbtn}> &hellip; </li>;
    }

    // const handleLoadMore = () => {
    //   setitemsPerPage(itemsPerPage + 3);
    // };

    const linkToDetail = (id) =>{
        history.push(`/detail/${id}`)
    }





    return (
        <> 
            {
                currentItems?.map((items, index) =>

                    <div className="col-4 mb-12" key={index}>
                        <div className="listCtquyengop" >
                            {/* <img className="img" src={`${api.serverUrl}/${items.images[0].name}`} alt={items.images[0].name} /> */}
                            <div>
                                <Carousel animation="zoom" autoplay="true" autoplayInterval="1000">
                                    {
                                        items.images?.map((img , index) => {
                                            return <img key={index} className="img" src={`${api.serverUrl}/${img.name}`} alt={img.name}/>
                                        })
                                    }
                                </Carousel>
                            </div>

                            
                            <div className="b">
                                <b > {items.name.substring(0,40)}...</b>
                            </div>
                            <div className="p">
                         
                                <ul>
                                    <li> Ngày bắt đầu:{items.dayStart}/{items.monthStart}/{items.yearStart}</li>
                                    <li> ngày kết thúc:{items.dayEnd}/{items.monthEnd}/{items.yearEnd}</li>
                                </ul>


                            </div>
                            <div >
                                <Button className="button-detail"  color="primary" onClick={() => linkToDetail(items.id)}>Xem Chi Tiết</Button>
                            </div>

                        </div>
                    </div>

                )}




            <ul className="pageNumbers">
                <li>
                    <button
                        onClick={handlePrevbtn}
                        disabled={currentPage === pages[0] ? true : false}
                    >
                        Prev
                    </button>
                </li>
                {pageDecrementBtn}
                {renderPageNumbers}
                {pageIncrementBtn}

                <li>
                    <button
                        onClick={handleNextbtn}
                        disabled={currentPage === pages[pages.length - 1] ? true : false}
                    >
                        Next
                    </button>
                </li>
            </ul>
            {/* <button onClick={handleLoadMore} className="loadmore">
          Load More
        </button> */}
            
            
        </>
    );
}

const mapGlobalStateToProps = state => {
    return {
        ctquyengops: selectListCtQuyenGop(state)
    };
};



export default connect(mapGlobalStateToProps, { getlistCtQuyenGopAction })(ListCtQuyenGops);
