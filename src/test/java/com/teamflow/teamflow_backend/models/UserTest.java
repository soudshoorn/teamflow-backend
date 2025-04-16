package com.teamflow.teamflow_backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserCreation() {
        // Arrange
        String username = "testuser";
        String displayName = "Test User";
        
        // Act
        User user = User.builder()
                .username(username)
                .displayName(displayName)
                .build();
        
        // Assert
        assertNotNull(user);
        assertEquals(username, user.getUsername());
        assertEquals(displayName, user.getDisplayName());
    }

    @Test
    void testUserSetters() {
        // Arrange
        User user = new User();
        String username = "newuser";
        String displayName = "New User";
        
        // Act
        user.setUsername(username);
        user.setDisplayName(displayName);
        
        // Assert
        assertEquals(username, user.getUsername());
        assertEquals(displayName, user.getDisplayName());
    }
} 