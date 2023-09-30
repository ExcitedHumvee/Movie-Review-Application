package com.stanydesa.movie.movies;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MovieTest {

    @Test
    void testMovieConstructorAndGetters() {
        // Given
        String imdbId = "tt123456";
        String title = "Example Movie";
        String releaseDate = "2023-01-01";
        String trailerLink = "https://www.example.com/trailer";
        String poster = "https://www.example.com/poster";
        List<String> backdrops = Arrays.asList("https://www.example.com/backdrop1", "https://www.example.com/backdrop2");
        List<String> genres = Arrays.asList("Action", "Drama");

        // When
        Movie movie = new Movie(imdbId, title, releaseDate, trailerLink, poster, backdrops, genres);

        // Then
        Assertions.assertNull(movie.getId(), "ID should be null");
        Assertions.assertEquals(imdbId, movie.getImdbId(), "IMDb ID should match");
        Assertions.assertEquals(title, movie.getTitle(), "Title should match");
        Assertions.assertEquals(releaseDate, movie.getReleaseDate(), "Release date should match");
        Assertions.assertEquals(trailerLink, movie.getTrailerLink(), "Trailer link should match");
        Assertions.assertEquals(poster, movie.getPoster(), "Poster should match");
        Assertions.assertEquals(backdrops, movie.getBackdrops(), "Backdrops should match");
        Assertions.assertEquals(genres, movie.getGenres(), "Genres should match");
        Assertions.assertNull(movie.getReviews(), "Reviews should be null");
    }
}
