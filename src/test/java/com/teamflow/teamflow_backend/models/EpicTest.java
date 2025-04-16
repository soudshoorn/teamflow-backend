package com.teamflow.teamflow_backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EpicTest {

    @Test
    void testEpicCreation() {
        // Arrange
        String title = "Test Epic";
        String description = "This is a test epic";
        
        // Act
        Epic epic = Epic.builder()
                .title(title)
                .description(description)
                .build();
        
        // Assert
        assertNotNull(epic);
        assertEquals(title, epic.getTitle());
        assertEquals(description, epic.getDescription());
    }

    @Test
    void testEpicSetters() {
        // Arrange
        Epic epic = new Epic();
        String title = "New Title";
        String description = "New Description";
        
        // Act
        epic.setTitle(title);
        epic.setDescription(description);
        
        // Assert
        assertEquals(title, epic.getTitle());
        assertEquals(description, epic.getDescription());
    }
} 