import * as types from "../constants";
import CtQuyenGopApi from '../../api/CtQuyenGopApi';
 

const listCtQuyenGopAction=(ctquyengops)=>{
    return {
        type: types.GET_LIST_CTQUYENGOP,
        payload: {
            ctquyengops
        }
    };
}

export const getlistCtQuyenGopAction = () => {
  return async dispatch => {
    try {
      console.log("có em");
      const ctquyengops = await CtQuyenGopApi.getCtQuyenGop();
      // const ctquyengops = json.content;
    //   const totalElement = json.totalElements;
      dispatch(listCtQuyenGopAction(ctquyengops));
    } catch (error) {
      console.log(error);
    }
  }
}

// const listGroupAction = (groups, page, totalElement, sortField, sortType, search, minTotalMember, maxTotalMember) => {
//   return {
//     type: types.GET_LIST_GROUP,
//     payload: {
//       groups,
//       // paging
//       page,
//       totalElement,
//       // sorting
//       sortField,
//       sortType,
//       // search
//       search,
//       // filter
//       minTotalMember,
//       maxTotalMember
//     }
//   };
// }

// export const getListGroupAction = (page, size, sortField, sortType, search, minTotalMember, maxTotalMember) => {
//   return async dispatch => {
//     try {
//       const json = await GroupApi.getAll(page, size, sortField, sortType, search, minTotalMember, maxTotalMember);
//       const groups = json.content;
//       const totalElement = json.totalElements;
//       dispatch(listGroupAction(groups,page, totalElement, sortField, sortType, search, minTotalMember, maxTotalMember));
//     } catch (error) {
//       console.log(error);
//     }
//   }
// }