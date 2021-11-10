import { createSelector } from "@reduxjs/toolkit";


const ctQuyenGopsSelector = (state) => state.ctQuyenGop;

const selectCtQuyenGops = createSelector(
    ctQuyenGopsSelector,
    state => state.ctQuyenGops
);


// function
export const selectCtQuyenGop = (state) => {
    return ctQuyenGopsSelector(state);
}