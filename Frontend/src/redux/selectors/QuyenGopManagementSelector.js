import { createSelector } from "@reduxjs/toolkit";

/** Selector **/
const QuyenGopManagementSelector = (state) => state.quyenGopManagement;

const selectListQuyenGopManagementSelector = createSelector(
    QuyenGopManagementSelector,
    state => state.quyenGopManagements);

const selectPageSelector = createSelector(
    QuyenGopManagementSelector,
    state => state.page);

const selectSizeSelector = createSelector(
    QuyenGopManagementSelector,
    state => state.size);

const selectTotalElementSelector = createSelector(
    QuyenGopManagementSelector,
    state => state.totalElement);

// const selectLoadingSelector = createSelector(
//     groupSelector,
//     state => state.isLoading);

/** function */
export const selectListQuyenGopManagement = (state) => {
    return selectListQuyenGopManagementSelector(state);
}

export const selectPage = (state) => {
    return selectPageSelector(state);
}

export const selectSize = (state) => {
    return selectSizeSelector(state);
}

export const selectTotalElement = (state) => {
    return selectTotalElementSelector(state);
}

// export const selectLoading = (state) => {
//     return selectLoadingSelector(state);
// }