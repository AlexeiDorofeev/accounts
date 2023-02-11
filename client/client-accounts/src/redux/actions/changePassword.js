import { CHANGE_PASSWORD } from './actionTypes';

export const changePassword = (newPassword) => {
    return {
        type: CHANGE_PASSWORD,
        payload: newPassword
    };
};
