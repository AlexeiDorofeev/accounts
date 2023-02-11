import { createSelector } from "reselect";

const getAuth = state => state.auth;

export const isLoggedIn = createSelector(
    [getAuth],
    auth => auth.isLoggedIn
);
