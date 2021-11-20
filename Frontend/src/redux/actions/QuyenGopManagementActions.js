import * as types from "../constants";
import ManagementApi from '../../api/QuyenGopManagementApi';

const listQuyenGopManagementAction = (quyenGopManagements, page, totalElement) => {
  return {
    type: types.GET_LIST_QuyenGopManagement,
    payload: {
      quyenGopManagements,
      page,
      totalElement
    }
  };
}

export const getListQuyenGopManagementAction = (page, size) => {
  return async dispatch => {
    try {
      const json = await ManagementApi.getAll(page, size);
      const QuyenGopManagements = json.content;
      const totalElement = json.totalElements;
      dispatch(listQuyenGopManagementAction(QuyenGopManagements, page, totalElement));
    } catch (error) {
      console.log(error);
    }
  }
}