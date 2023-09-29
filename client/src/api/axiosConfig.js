import axios from 'axios';

export default axios.create({
    baseURL:process.env.REACT_APP_AXIOS_BASE_TOKEN,
    headers: {"ngrok-skip-browser-warning": "true"}//for request not to be blocked because of CORS, Cross origin resource sharing
});