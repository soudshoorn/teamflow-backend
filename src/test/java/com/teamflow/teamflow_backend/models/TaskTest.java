package com.teamflow.teamflow_backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    void testTaskCreation() {
        // Arrange
        String title = "Test Task";
        String description = "This is a test task";
        
        // Act
        Task task = Task.builder()
                .title(title)
                .description(description)
                .build();
        
        // Assert
        assertNotNull(task);
        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertNull(task.getUserStory());
    }

    @Test
    void testTaskWithUserStory() {
        // Arrange
        String title = "Test Task";
        UserStory userStory = new UserStory();
        
        // Act
        Task task = Task.builder()
                .title(title)
                .userStory(userStory)
                .build();
        
        // Assert
        assertNotNull(task);
        assertEquals(title, task.getTitle());
        assertEquals(userStory, task.getUserStory());
    }

    @Test
    void testTaskSetters() {
        // Arrange
        Task task = new Task();
        String title = "New Title";
        String description = "New Description";
        UserStory userStory = new UserStory();
        
        // Act
        task.setTitle(title);
        task.setDescription(description);
        task.setUserStory(userStory);
        
        // Assert
        assertEquals(title, task.getTitle());
        assertEquals(description, task.getDescription());
        assertEquals(userStory, task.getUserStory());
    }
} 