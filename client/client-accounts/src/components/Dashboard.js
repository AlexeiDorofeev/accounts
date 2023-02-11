import axios from 'axios';
import {useSelector} from 'react-redux';
import {useState} from "react";

const Dashboard = async () => {
    const currentUser = useSelector(state => state.currentUser);
    const {user} = currentUser;

    const [formValues, setFormValues] = useState({
        currentPassword: "",
        newPassword: "",
    });
    const handleChangePassword = async () => {
        try {
            const response = await axios.post('/api/changepass', {
                username: user.username,
                oldPassword: formValues.currentPassword,
                newPassword: formValues.newPassword
            });

            if (response.status === 200) {
                console.log('Password changed successfully');
            }
        } catch (error) {
            console.error(error);
        }
    }

    const handleInputChange = (event) => {
        setFormValues({...formValues, [event.target.name]: event.target.value});
    };

    return (
        <div>
            <input
                type="password"
                name="currentPassword"
                placeholder="Current password"
                value={formValues.currentPassword}
                onChange={handleInputChange}
            />
            <input
                type="password"
                name="newPassword"
                placeholder="New password"
                value={formValues.newPassword}
                onChange={handleInputChange}
            />
            <button onClick={handleChangePassword}>Change password</button>
        </div>
    );

}

export default Dashboard;
