package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.UserStory;
import com.teamflow.teamflow_backend.services.UserStoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserStoryControllerTest {

    @Mock
    private UserStoryService userStoryService;

    @InjectMocks
    private UserStoryController userStoryController;

    @Test
    void testGetAllUserStories() {
        // Arrange
        UserStory story1 = new UserStory();
        story1.setId(1L);
        story1.setTitle("Story 1");
        story1.setDescription("Description 1");

        UserStory story2 = new UserStory();
        story2.setId(2L);
        story2.setTitle("Story 2");
        story2.setDescription("Description 2");

        List<UserStory> stories = Arrays.asList(story1, story2);
        when(userStoryService.getAllUserStories()).thenReturn(stories);

        // Act
        List<UserStory> result = userStoryController.getAllUserStories();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(story1, result.get(0));
        assertEquals(story2, result.get(1));
        verify(userStoryService, times(1)).getAllUserStories();
    }

    @Test
    void testGetUserStoryById() {
        // Arrange
        Long storyId = 1L;
        UserStory story = new UserStory();
        story.setId(storyId);
        story.setTitle("Test Story");
        story.setDescription("Test Description");

        when(userStoryService.getUserStoryById(storyId)).thenReturn(story);

        // Act
        UserStory result = userStoryController.getUserStoryById(storyId);

        // Assert
        assertNotNull(result);
        assertEquals(storyId, result.getId());
        assertEquals("Test Story", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        verify(userStoryService, times(1)).getUserStoryById(storyId);
    }

    @Test
    void testCreateUserStory() {
        // Arrange
        UserStory newStory = new UserStory();
        newStory.setTitle("New Story");
        newStory.setDescription("New Description");

        UserStory savedStory = new UserStory();
        savedStory.setId(1L);
        savedStory.setTitle("New Story");
        savedStory.setDescription("New Description");

        when(userStoryService.createUserStory(newStory)).thenReturn(savedStory);

        // Act
        UserStory result = userStoryController.createUserStory(newStory);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Story", result.getTitle());
        assertEquals("New Description", result.getDescription());
        verify(userStoryService, times(1)).createUserStory(newStory);
    }

    @Test
    void testUpdateUserStory() {
        // Arrange
        Long storyId = 1L;
        UserStory updatedStory = new UserStory();
        updatedStory.setTitle("Updated Story");
        updatedStory.setDescription("Updated Description");

        UserStory savedStory = new UserStory();
        savedStory.setId(storyId);
        savedStory.setTitle("Updated Story");
        savedStory.setDescription("Updated Description");

        when(userStoryService.updateUserStory(storyId, updatedStory)).thenReturn(savedStory);

        // Act
        UserStory result = userStoryController.updateUserStory(storyId, updatedStory);

        // Assert
        assertNotNull(result);
        assertEquals(storyId, result.getId());
        assertEquals("Updated Story", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
        verify(userStoryService, times(1)).updateUserStory(storyId, updatedStory);
    }

    @Test
    void testDeleteUserStory() {
        // Arrange
        Long storyId = 1L;
        when(userStoryService.deleteUserStory(storyId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = userStoryController.deleteUserStory(storyId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userStoryService, times(1)).deleteUserStory(storyId);
    }
} 