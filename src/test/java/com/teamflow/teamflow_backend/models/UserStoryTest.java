package com.teamflow.teamflow_backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserStoryTest {

    @Test
    void testUserStoryCreation() {
        // Arrange
        String title = "Test User Story";
        String description = "This is a test user story";
        
        // Act
        UserStory userStory = UserStory.builder()
                .title(title)
                .description(description)
                .build();
        
        // Assert
        assertNotNull(userStory);
        assertEquals(title, userStory.getTitle());
        assertEquals(description, userStory.getDescription());
        assertNull(userStory.getEpic());
    }

    @Test
    void testUserStoryWithEpic() {
        // Arrange
        String title = "Test User Story";
        Epic epic = new Epic();
        
        // Act
        UserStory userStory = UserStory.builder()
                .title(title)
                .epic(epic)
                .build();
        
        // Assert
        assertNotNull(userStory);
        assertEquals(title, userStory.getTitle());
        assertEquals(epic, userStory.getEpic());
    }

    @Test
    void testUserStorySetters() {
        // Arrange
        UserStory userStory = new UserStory();
        String title = "New Title";
        String description = "New Description";
        Epic epic = new Epic();
        
        // Act
        userStory.setTitle(title);
        userStory.setDescription(description);
        userStory.setEpic(epic);
        
        // Assert
        assertEquals(title, userStory.getTitle());
        assertEquals(description, userStory.getDescription());
        assertEquals(epic, userStory.getEpic());
    }
} 