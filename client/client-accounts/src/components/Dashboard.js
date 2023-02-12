import {useState} from "react";
import {useSelector} from "react-redux";
import {currentUser} from "../redux/auth-selectors/isLoggedIn";

const Dashboard = () => {
    const selector = useSelector(currentUser);

    const [formValues, setFormValues] = useState({
        currentPassword: "",
        newPassword: "",
    });

    const handleInputChange = (event) => {
        setFormValues({...formValues, [event.target.name]: event.target.value});
    };

    return (
        <div>
            <div>{selector.name} {selector.lastname}</div>
            {/*<input*/}
            {/*    type="password"*/}
            {/*    name="currentPassword"*/}
            {/*    placeholder="Current password"*/}
            {/*    value={formValues.currentPassword}*/}
            {/*    onChange={handleInputChange}*/}
            {/*/>*/}
            <input
                type="password"
                name="newPassword"
                placeholder="New password"
                //     value={formValues.newPassword}
                onChange={handleInputChange}
            />
        </div>
    )
        ;
}

export default Dashboard;
