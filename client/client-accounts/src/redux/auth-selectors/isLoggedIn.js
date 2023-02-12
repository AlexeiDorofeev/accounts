import { createSelector } from "reselect";

const getAuth = state => state.auth;

export const isLoggedIn = createSelector(
    [getAuth],
    auth => auth.isLoggedIn
);

export const currentUser = createSelector(
    [getAuth],
    auth => auth.currentUser
);
