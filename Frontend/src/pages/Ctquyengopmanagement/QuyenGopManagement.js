import React, { useState, useEffect } from "react";
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
  ModalHeader
} from "reactstrap";
import { getListQuyenGopManagementAction } from '../../redux/actions/QuyenGopManagementActions';
import { connect } from "react-redux";
import * as Icon from "react-feather";
import { Formik, FastField, Form } from 'formik';
import { ReactstrapInput } from "reactstrap-formik";
// import * as Yup from 'yup';
import { toastr } from "react-redux-toastr";
// import ToolkitProvider from 'react-bootstrap-table2-toolkit';
import QuyenGopManagementApi from "../../api/QuyenGopManagementApi"
import BootstrapTable from "react-bootstrap-table-next";
import paginationFactory from 'react-bootstrap-table2-paginator';
import { selectListQuyenGopManagement, selectPage, selectSize, selectTotalElement } from '../../redux/selectors/QuyenGopManagementSelector';

const QuyenGopManagement = (props) => {
  console.log(props.quyenGopManagements);
  const getListQuyenGopManagements = props.getListQuyenGopManagementAction;
  const size = props.size;

  useEffect(() => {
    getListQuyenGopManagements(1, size);
  }, [getListQuyenGopManagements, size]);

  const tableColumns = [
    {
      dataField: "name",
      text: "Name",
      sort: true
    },
    {
      dataField: "tienQuyenGop",
      text: "Tiền Quyên Góp",
      sort: true
    },

    {
      dataField: "date_Start",
      text: "Ngày Bắt Đầu",
      sort: true
    },
    {
      dataField: "date_End",
      text: "Ngày Kết Thúc",
      sort: true
    },

  ];



  //create
  const [isOpenModal, setOpenModal] = useState(false);



  const showSuccessNotification = (title, message) => {
    const options = {
      timeOut: 2500,
      showCloseButton: false,
      progressBar: false,
      position: "top-right"
    };

    // show notification
    toastr.success(title, message, options);
  }



  const handleTableChange = (type, { page, sizePerPage }) => {
    getListQuyenGopManagements(page, sizePerPage);
  }

  return (
    <Container fluid className="p-0">
      <h1 className="h3 mb-3">Quyen Gop Management</h1>

      {/* <Row>
        <Col> */}
      <Card>
        <CardBody>
          <Row>
            {/* <Col>
                  {isVisibleFilter && <Filter onFilterChange={onFilterChange} />}
                </Col>
              </Row>
              <Row style={{ alignItems: "flex-end" }}>
                <Col xs="9">
                  <CustomSearch {...toolkitprops.searchProps} />
                </Col> */}
            <Col xs="3" style={{ paddingBottom: 20 }}>
              <div className="float-right pull-right">
                {/* filter button */}
                {/* <Icon.Filter size="24" className="align-middle mr-2" onClick={() => setVisibleFilter(!isVisibleFilter)} />
                    <Icon.RefreshCcw size="24" className="align-middle mr-2" onClick={() => refreshForm()} /> */}
                <Icon.PlusCircle size="24" className="align-middle mr-2" onClick={() => setOpenModal(true)} />
              </div>
            </Col>
          </Row>



          <BootstrapTable
            keyField="name"
            data= {props.quyenGopManagements}
            columns={tableColumns}
            bootstrap4
            striped
            hover
            bordered
            remote
            pagination={paginationFactory({
              page: props.page,
              totalSize: props.totalElement,
              sizePerPage: props.size,

              nextPageText: '>',
              prePageText: '<',
              withFirstAndLast: false,
              alwaysShowAllBtns: true,

              hideSizePerPage: true,

            })}
            onTableChange={handleTableChange}
          />
        </CardBody>
      </Card>



      <Modal
        isOpen={isOpenModal}
      >
        <Formik
          initialValues={
            {
              name: '',
              start: '',
              end : '',
              discrip : '',
              tongTien : '',
              image1 : '',
              image2 : '',
              image3 : '',
              bankName1 : '',
              imageBank1 :'',
              stk1 : '',
              bankName2 : '',
              imageBank2 :'',
              stk2 : ''
            }
          }
          // validationSchema={
          //   Yup.object({
          //     name: Yup.string()
          //       .required('Required')
          //       .max(50, 'Must be between 6 to 50 characters')
          //       .min(6, 'Must be between 6 to 50 characters')
          //       .test('checkUniqueName', 'This name is already exists.', async name => {
          //         const isExists = await QuyenGopManagementApi.existsByName(name);
          //         return !isExists;
          //       })
          //   })
          // }


          onSubmit={
            async (values) => {
              try {

                
               

                // call api
                const name = values.name
                const start = values.start
                const end = values.end
                const discrip = values.discrip
                const tongTien = values.tongTien
                const image1 = values.image1
                const image2 = values.image2
                const image3 = values.image3
                const bankName1 = values.bankName1 
                const imageBank1 = values.imageBank1
                const stk1 = values.stk1
                const bankName2 = values.bankName2
                const imageBank2 = values.imageBank2
                const stk2 = values.stk2


                await QuyenGopManagementApi.create(name,start,
                  end,discrip,tongTien,
                  image1,image2,image3,
                  bankName1,imageBank1,stk1,
                  bankName2,imageBank2,stk2                 
                  );

                  // await QuyenGopManagementApi.create( formdata );
                setOpenModal(false);
                // show notification
                showSuccessNotification(
                  "Create QuyenGopManagement",
                  "Create QuyenGopManagement Successfully!");
                // reload QuyenGopManagement page
                // refreshForm();

              } catch (error) {
                console.log(error);
                setOpenModal(false);
              }
            }
          }



          validateOnChange={false}
          validateOnBlur={false}
        >
          {({ isSubmitting }) => (
            <Form >
              {/* header */}
              <ModalHeader>
                Tạo Mới Chương Trình Quyên Góp
              </ModalHeader>

              <ModalBody className="m-3">

                {/* Firstname */}
                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    Tên Chương Trình:
                  </Col>
                  <Col>
                    <FastField
                      //label="QuyenGopManagement Name"
                      bsSize="large"
                      type="text"
                      name="name"
                      placeholder="Enter QuyenGopManagement Name"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>


                  {/* Discription */}
                  <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Discription:
                  </Col>
                  <Col>
                    <FastField
                      //label="QuyenGopManagement Name"
                      bsSize="lg"
                      type="textarea"
                      name="discrip"
                      placeholder="Discription"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                 {/* Ngày bắt đầu */}
                 <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Ngày bắt đầu:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="date"
                      name="start"
                      placeholder="Ngày bắt đầu"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                  {/* Ngày kết thúc */}
                  <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Ngày kết thúc:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="date"
                      name="end"
                      placeholder="Ngày kết thúc"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                 {/* image1 của CT Quyên Góp */}
                 <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Image1 CT:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="file"
                      name="image1"
                      placeholder="image1"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                   {/* image2 của CT Quyên Góp */}
                   <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Image2 CT:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="file"
                      name="image2"
                      placeholder="image2"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                   {/* image3 của CT Quyên Góp */}
                   <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Image1 CT:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="file"
                      name="image3"
                      placeholder="image3"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>


                {/* Ngân hàng 1 */}
                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    BankName 1:
                  </Col>
                  <Col>
                    <FastField
                      //label="QuyenGopManagement Name"
                      bsSize="large"
                      type="text"
                      name="bankName1"
                      placeholder="Enter BankName 1"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Ảnh Bank1:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="file"
                      name="imageBank1"
                      placeholder="imageBank1"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    Số Tk Bank1:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="number"
                      name="stk1"
                      placeholder="Enter Số Tk Bank1"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>
                

                {/* Ngân hàng 2 */}
                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    BankName 2:
                  </Col>
                  <Col>
                    <FastField
                      //label="QuyenGopManagement Name"
                      bsSize="large"
                      type="text"
                      name="bankName2"
                      placeholder="Enter BankName 2"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                     Ảnh Bank2:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="file"
                      name="imageBank2"
                      placeholder="imageBank2"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>

                <Row style={{ alignItems: "center" }}>
                  <Col xs="auto">
                    Số Tk Bank2:
                  </Col>
                  <Col>
                    <FastField
                      bsSize="large"
                      type="number"
                      name="stk2"
                      placeholder="Enter Số Tk Bank2"
                      component={ReactstrapInput}
                    />
                  </Col>
                </Row>
                


              </ModalBody>


              <ModalFooter>

                <Button
                  color="primary"
                  style={{ marginLeft: 10 }}
                  disabled={isSubmitting}
                  type="submit"
                >
                  Save
                </Button>

                {/* close button */}
                <Button
                  color="primary"
                  onClick={() => setOpenModal(false)}
                >
                  Cancel
                </Button>

              </ModalFooter>
            </Form>
          )}
        </Formik>
      </Modal>




      {/* 
        </Col>
      </Row> */}




    </Container>
  )
};

const mapGlobalStateToProps = state => {
  return {
    quyenGopManagements:selectListQuyenGopManagement(state),
    page: selectPage(state),
    size: selectSize(state),
    totalElement: selectTotalElement(state)
  };
};

export default connect(mapGlobalStateToProps, { getListQuyenGopManagementAction })(QuyenGopManagement);


