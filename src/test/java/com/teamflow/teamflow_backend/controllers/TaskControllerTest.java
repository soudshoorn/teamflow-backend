package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.Task;
import com.teamflow.teamflow_backend.services.TaskService;
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
class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    @Test
    void testGetAllTasks() {
        // Arrange
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");

        List<Task> tasks = Arrays.asList(task1, task2);
        when(taskService.getAllTasks()).thenReturn(tasks);

        // Act
        List<Task> result = taskController.getAllTasks();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(task1, result.get(0));
        assertEquals(task2, result.get(1));
        verify(taskService, times(1)).getAllTasks();
    }

    @Test
    void testGetTaskById() {
        // Arrange
        Long taskId = 1L;
        Task task = new Task();
        task.setId(taskId);
        task.setTitle("Test Task");
        task.setDescription("Test Description");

        when(taskService.getTaskById(taskId)).thenReturn(task);

        // Act
        Task result = taskController.getTaskById(taskId);

        // Assert
        assertNotNull(result);
        assertEquals(taskId, result.getId());
        assertEquals("Test Task", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        verify(taskService, times(1)).getTaskById(taskId);
    }

    @Test
    void testCreateTask() {
        // Arrange
        Task newTask = new Task();
        newTask.setTitle("New Task");
        newTask.setDescription("New Description");

        Task savedTask = new Task();
        savedTask.setId(1L);
        savedTask.setTitle("New Task");
        savedTask.setDescription("New Description");

        when(taskService.createTask(newTask)).thenReturn(savedTask);

        // Act
        Task result = taskController.createTask(newTask);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Task", result.getTitle());
        assertEquals("New Description", result.getDescription());
        verify(taskService, times(1)).createTask(newTask);
    }

    @Test
    void testUpdateTask() {
        // Arrange
        Long taskId = 1L;
        Task updatedTask = new Task();
        updatedTask.setTitle("Updated Task");
        updatedTask.setDescription("Updated Description");

        Task savedTask = new Task();
        savedTask.setId(taskId);
        savedTask.setTitle("Updated Task");
        savedTask.setDescription("Updated Description");

        when(taskService.updateTask(taskId, updatedTask)).thenReturn(savedTask);

        // Act
        Task result = taskController.updateTask(taskId, updatedTask);

        // Assert
        assertNotNull(result);
        assertEquals(taskId, result.getId());
        assertEquals("Updated Task", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
        verify(taskService, times(1)).updateTask(taskId, updatedTask);
    }

    @Test
    void testDeleteTask() {
        // Arrange
        Long taskId = 1L;
        when(taskService.deleteTask(taskId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = taskController.deleteTask(taskId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(taskService, times(1)).deleteTask(taskId);
    }
} 