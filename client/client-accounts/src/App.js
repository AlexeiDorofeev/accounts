import LoginForm from './components/LoginForm'
import Dashboard from "./components/Dashboard";
import {BrowserRouter} from 'react-router-dom';
import {useSelector} from 'react-redux';


function App() {
    const isAuthenticated = useSelector(state => state.auth.isAuthenticated);

    return (
            <div className="App">
                <BrowserRouter>
                    {isAuthenticated ? <Dashboard/> : <LoginForm/>}
                </BrowserRouter>
            </div>
    );
}

export default App
