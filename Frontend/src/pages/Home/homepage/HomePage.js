
import React from "react";
import { useEffect } from "react";
import ListCtQuyenGops from "../listctquyengop/ListCtQuyenGops";

import "./HomePage.scss";
import { getlistCtQuyenGopAction } from '../../../redux/actions/CtQuyenGopAction';
import { selectListCtQuyenGop } from '../../../redux/selectors/CtQuyenGopSelector';
import { connect } from "react-redux";
// import paginationFactory from 'react-bootstrap-table2-paginator';
// import BootstrapTable from "react-bootstrap-table-next";
const HomePage = (props) => {


    const getListCtQuyenGops = props.getlistCtQuyenGopAction;
    const quyenGops = props.ctquyengops;
    // const lists = quyenGops?.map((items) =>

    //     <ListCtQuyenGops key={items.id} value={items} />
    // );
    // const [QuyenGop, setQuyenGop] = useState();

    useEffect(() => {


        getListCtQuyenGops();
    }, [getListCtQuyenGops]);





    return (

        <>
            <div className="container">
                {/* <div className="row"><img className="logo" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRm6Zd55XnrTE9ZxOUDQHlaBclCVy7tNQa2PQ&usqp=CAU" alt="" /></div> */}

                {/* <div className="row">
                   
                </div> */}

                <div className="row">
                    <h3 className="h3"> Các chương trình Quyên góp</h3>
                </div>


                <div className="row">
                    {
                        quyenGops?.map((items, index) =>

                            <div className="col-4 mb-12">
                                <ListCtQuyenGops key={index} value={items} />
                            </div>
                        )}

                </div>


              

            </div>
        </>

    );



}



const mapGlobalStateToProps = state => {
    return {
        ctquyengops: selectListCtQuyenGop(state)
        //   groups: selectListGroup(state),
        //   page: selectPage(state),
        //   size: selectSize(state),
        //   totalElement: selectTotalElement(state),
        //   sortField: selectSortField(state),
        //   sortType: selectSortType(state)
    };
};

export default connect(mapGlobalStateToProps, { getlistCtQuyenGopAction })(HomePage);
