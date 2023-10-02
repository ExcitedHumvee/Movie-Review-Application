package com.stanydesa.movie.movies;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.ExecutableUpdateOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceTest {

    @Mock
    private ReviewRepository mockRepository;

    @Mock
    private MongoTemplate mockMongoTemplate;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    public void testCreateReview() {
        // Arrange
        String reviewBody = "Great movie!";
        String imdbId = "tt1234567";

        Review savedReview = new Review(reviewBody, LocalDateTime.now(), LocalDateTime.now());
        when(mockRepository.insert(any(Review.class))).thenReturn(savedReview);

        // Creating a mock ExecutableUpdateOperation.ExecutableUpdate for the mongoTemplate.update method
        ExecutableUpdateOperation.ExecutableUpdate mockExecutableUpdate = mock(ExecutableUpdateOperation.ExecutableUpdate.class);
        ExecutableUpdateOperation.TerminatingUpdate mockTerminatingUpdate = mock(ExecutableUpdateOperation.TerminatingUpdate.class);
        when(mockMongoTemplate.update(any())).thenReturn(mockExecutableUpdate);

        // Mocking matching and apply methods on ExecutableUpdate
        when(mockExecutableUpdate.matching(any(Criteria.class))).thenReturn(mockExecutableUpdate);
        when(mockExecutableUpdate.apply(any(Update.class))).thenReturn(mockTerminatingUpdate);
        when(mockTerminatingUpdate.first()).thenReturn(null);


        // Act
        Review result = reviewService.createReview(reviewBody, imdbId);

        // Assert
        // Verify that repository.insert is called with the correct argument
        verify(mockRepository, times(1)).insert(any(Review.class));

        // Verify that mongoTemplate.update is called with the correct arguments
        verify(mockMongoTemplate, times(1)).update(eq(Movie.class));

        // Assert the returned review
        assertEquals(savedReview, result);
    }
}
