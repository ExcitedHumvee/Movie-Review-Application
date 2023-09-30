import './App.css';
import api from './api/axiosConfig';
// Importing React hooks for state and lifecycle management
import {
    useState,
    useEffect
} from 'react';
import Layout from './components/Layout';
// Importing React Router components for defining routes
import {
    Routes,
    Route
} from 'react-router-dom';
//importing components
import Home from './components/home/Home';
import Header from './components/header/Header';
import Trailer from './components/trailer/Trailer';
import Reviews from './components/reviews/Reviews';
import NotFound from './components/notFound/NotFound';

function App() {
    console.log(process.env.REACT_APP_AXIOS_BASE_TOKEN);
    //current state and function to change state
    const [movies, setMovies] = useState();
    const [movie, setMovie] = useState();
    const [reviews, setReviews] = useState([]);//[] The empty dependency array ([]) ensures that the effect runs only once. If you have dependencies, the effect will re-run whenever those dependencies change.useEffect hook is used to fetch data when the component mounts. 

    const getMovies = async () => {
        try {
            const response = await api.get("/api/v1/movies"); //Asynchronous
            console.log(response.data) ;
            setMovies(response.data);//chnaging the state
        } catch (err) {
            console.log(err);
        }
    }

    const getMovieData = async (movieId) => {
        try {
            const response = await api.get(`/api/v1/movies/${movieId}`);
            const singleMovie = response.data; 
            setMovie(singleMovie);
            setReviews(singleMovie.reviews);
        } catch (error) {
            console.error(error);
        }
    }

    // useEffect hook to fetch movies when the component mounts/rendered
    useEffect(() => {getMovies();}, [])//calling getMovies()

    return (//main JSX JS XML 
        <div className="App">
            <Header/>
            <Routes>
                <Route path="/" element={<Layout/>}>
                    {/* element={<Home movies={movies}/>} : Passes the movies state as a prop to the Home component. */}
                    <Route path="/" element={<Home movies={movies}/>} ></Route>
                    <Route path="/Trailer/:ytTrailerId" element={<Trailer/>}></Route>
                    <Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
                    <Route path="*" element = {<NotFound/>}></Route>
                </Route>
            </Routes>
        </div>
    );
}
export default App;
//this React application fetches a list of movies when the component mounts, allows navigation between different views using React Router, and fetches additional data for specific movies as needed. The structure is modular, with separate components for the header, home, trailer, reviews, and a not-found page.