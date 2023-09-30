package com.stanydesa.movie.movies;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    @Test
    void testReviewCreation() {
        // Given
        String body = "This is a great movie!";
        LocalDateTime created = LocalDateTime.of(2023, 1, 1, 12, 0);
        LocalDateTime updated = LocalDateTime.of(2023, 1, 2, 14, 30);

        // When
        Review review = new Review(body, created, updated);

        // Then
        assertNotNull(review, "Review should not be null");
        assertNull(review.getId(), "Review ID should not be null");
        assertEquals(body, review.getBody(), "Body should match");
        assertEquals(created, review.getCreated(), "Created timestamp should match");
        assertEquals(updated, review.getUpdated(), "Updated timestamp should match");
    }

    @Test
    void testGetterAndSetter() {
        // Given
        Review review = new Review();

        // When
        ObjectId id = new ObjectId();
        String body = "Updated review body";
        LocalDateTime updated = LocalDateTime.now();

        review.setId(id);
        review.setBody(body);
        review.setUpdated(updated);

        // Then
        assertEquals(id, review.getId(), "Review ID should match");
        assertEquals(body, review.getBody(), "Body should match");
        assertEquals(updated, review.getUpdated(), "Updated timestamp should match");
    }
}
