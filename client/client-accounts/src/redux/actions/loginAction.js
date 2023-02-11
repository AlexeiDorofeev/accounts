import axios from 'axios'
import {SET_AUTHENTICATED} from "./actionTypes";

export const login = (username, password) => dispatch => {
    axios.post("/api/auth/me", { username, password })
        .then(res => {
            dispatch({ type: SET_AUTHENTICATED, payload: res.data.user });
        })
        .catch(err => {
            console.error(err);
        });
};
