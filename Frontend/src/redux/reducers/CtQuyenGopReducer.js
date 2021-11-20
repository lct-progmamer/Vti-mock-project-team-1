import * as types from "../constants";

const initialState = {
  ctquyengops: [],

  
};

export default function reducer(state = initialState, actions) {
  switch (actions.type) {
    case types.GET_LIST_CTQUYENGOP:
      return {
        ...state,
        ctquyengops: actions.payload.ctquyengops,
        // // paging
        // page: actions.payload.page,
        // totalElement: actions.payload.totalElement,
        // // sorting
        // sortField: actions.payload.sortField,
        // sortType: actions.payload.sortType,
        // // search
        // search: actions.payload.search,
        // // filter
        // minTotalMember: actions.payload.minTotalMember,
        // maxTotalMember: actions.payload.maxTotalMember,

        // isLoading: false
      };
    default:
      return state;
  }
}