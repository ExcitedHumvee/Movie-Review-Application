package com.stanydesa.movie.movies;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class MovieControllerTest {

    @Test
    void testGetMovies() {
        // Given
        MovieService movieService = mock(MovieService.class);
        List<Movie> movies = Arrays.asList(
                new Movie("tt123456", "Movie 1", "2023-01-01", "https://trailer1.com", "https://poster1.com", Arrays.asList("https://backdrop1.com"), Arrays.asList("Action")),
                new Movie("tt789012", "Movie 2", "2023-01-02", "https://trailer2.com", "https://poster2.com", Arrays.asList("https://backdrop2.com"), Arrays.asList("Drama"))
        );
        when(movieService.findAllMovies()).thenReturn(movies);

        MovieController movieController = new MovieController();
        movieController.setService(movieService);

        // When
        ResponseEntity<List<Movie>> responseEntity = movieController.getMovies();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");
        assertNotNull(responseEntity.getBody(), "Response body should not be null");
        assertEquals(2, responseEntity.getBody().size(), "Number of movies in the response should be 2");
    }

    @Test
    void testGetSingleMovie() {
        // Given
        MovieService movieService = mock(MovieService.class);
        Movie movie = new Movie("tt123456", "Movie 1", "2023-01-01", "https://trailer1.com", "https://poster1.com", Arrays.asList("https://backdrop1.com"), Arrays.asList("Action"));
        when(movieService.findMovieByImdbId("tt123456")).thenReturn(Optional.of(movie));

        MovieController movieController = new MovieController();
        movieController.setService(movieService);

        // When
        ResponseEntity<Optional<Movie>> responseEntity = movieController.getSingleMovie("tt123456");

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), "HTTP Status should be OK");
        assertNotNull(responseEntity.getBody(), "Response body should not be null");
        assertEquals("tt123456", responseEntity.getBody().get().getImdbId(), "IMDb ID in the response should match");
    }
}
