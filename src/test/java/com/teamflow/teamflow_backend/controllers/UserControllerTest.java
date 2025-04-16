package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.User;
import com.teamflow.teamflow_backend.services.UserService;
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
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    void testGetAllUsers() {
        // Arrange
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("user1");
        user1.setDisplayName("User One");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("user2");
        user2.setDisplayName("User Two");

        List<User> users = Arrays.asList(user1, user2);
        when(userService.getAllUsers()).thenReturn(users);

        // Act
        List<User> result = userController.getAllUsers();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setUsername("testuser");
        user.setDisplayName("Test User");

        when(userService.getUserById(userId)).thenReturn(user);

        // Act
        User result = userController.getUserById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("testuser", result.getUsername());
        assertEquals("Test User", result.getDisplayName());
        verify(userService, times(1)).getUserById(userId);
    }

    @Test
    void testCreateUser() {
        // Arrange
        User newUser = new User();
        newUser.setUsername("newuser");
        newUser.setDisplayName("New User");

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername("newuser");
        savedUser.setDisplayName("New User");

        when(userService.createUser(newUser)).thenReturn(savedUser);

        // Act
        User result = userController.createUser(newUser);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("newuser", result.getUsername());
        assertEquals("New User", result.getDisplayName());
        verify(userService, times(1)).createUser(newUser);
    }

    @Test
    void testUpdateUser() {
        // Arrange
        Long userId = 1L;
        User updatedUser = new User();
        updatedUser.setUsername("updateduser");
        updatedUser.setDisplayName("Updated User");

        User savedUser = new User();
        savedUser.setId(userId);
        savedUser.setUsername("updateduser");
        savedUser.setDisplayName("Updated User");

        when(userService.updateUser(userId, updatedUser)).thenReturn(savedUser);

        // Act
        User result = userController.updateUser(userId, updatedUser);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getId());
        assertEquals("updateduser", result.getUsername());
        assertEquals("Updated User", result.getDisplayName());
        verify(userService, times(1)).updateUser(userId, updatedUser);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long userId = 1L;
        when(userService.deleteUser(userId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = userController.deleteUser(userId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(userService, times(1)).deleteUser(userId);
    }
} 