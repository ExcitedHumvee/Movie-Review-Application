# Movie Review Application

## Overview

The Movie Review Application is a small-scale web application designed to manage and display movie reviews. The project follows a modern and modular architecture, utilizing MongoDB for the database, Java with Spring Boot for the backend, and React for the frontend. The primary goal of the project is to demonstrate the implementation of a loosely coupled architecture, allowing the client and server components to evolve independently.

## Features

- **Separation of Concerns:** The application emphasizes a clear separation of concerns between the client and server code. The frontend, developed in React, and the backend, implemented in Java with Spring Boot, are distinct entities that communicate through well-defined APIs.

- **MongoDB Integration:** The project uses MongoDB as the database to store and retrieve movie reviews. This NoSQL database provides flexibility and scalability for managing data related to movies, and reviews.

- **RESTful API:** The backend exposes a RESTful API that the frontend consumes to perform operations on movie reviews. This API allows for seamless communication and interaction between the client and server.

## Project Structure

The repository is organized into two main directories: `client` for the React frontend and `server` for the Java Spring Boot backend. Each directory contains its own set of dependencies, build configurations, and scripts.

### Frontend (client)

- The `client` directory holds all the code related to the React frontend.
- Use `npm install` to install the necessary dependencies.
- Run `npm start` to launch the development server for the frontend.

### Backend (server)

- The `server` directory contains the Java Spring Boot application.
- Use a Java IDE or build tools like Maven to manage dependencies and build the backend.
- Run the backend using the provided scripts or your preferred method.
- Run the SpringBootApplication `MovieApplication` from the Java IDE.

## Getting Started

To set up the Movie Review Application on your local machine, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/your-username/movie-review-application.git
   cd movie-review-application


2.  **Set up the Backend:**
    -   Navigate to the `server` directory.
    -   Configure the Mongo database connection in the `application.properties` file.
    -   Load the data from `_data/movies.json` into the configured database.
    -   Build and run the Spring Boot application.
3.  **Set up the Frontend:**
    
    -   Navigate to the `client` directory.
    -   Run `npm install` to install frontend dependencies.
    -   Start the React development server with `npm start`.
4.  **Access the Application:**
    -   Open your web browser and go to `http://localhost:3000` to access the Movie Review Application.
  

## Contributing

If you'd like to contribute to the project, please follow the standard GitHub workflow:

1.  **Fork the repository.**
2.  **Create a new branch:** `git checkout -b feature-name`.
3.  **Make your changes and commit them:** `git commit -m "Description of changes"`.
4.  **Push your branch to your fork:** `git push origin feature-name`.
5.  **Create a pull request on the main repository.**
