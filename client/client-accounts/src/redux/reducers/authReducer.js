import { SET_AUTHENTICATED, SET_UNAUTHENTICATED } from "../actions/actionTypes";

const initialState = {
    isAuthenticated: false
};

const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_AUTHENTICATED:
            return {
                ...state,
                isAuthenticated: true,
                currentUser: action.payload
            };
        case SET_UNAUTHENTICATED:
            return {
                ...state,
                isAuthenticated: false,
                currentUser: {}
            };
        default:
            return state;
    }
};

export default authReducer;
