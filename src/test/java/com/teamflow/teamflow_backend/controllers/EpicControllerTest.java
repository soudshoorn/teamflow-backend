package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.Epic;
import com.teamflow.teamflow_backend.services.EpicService;
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
class EpicControllerTest {

    @Mock
    private EpicService epicService;

    @InjectMocks
    private EpicController epicController;

    @Test
    void testGetAllEpics() {
        // Arrange
        Epic epic1 = new Epic();
        epic1.setId(1L);
        epic1.setTitle("Epic 1");
        epic1.setDescription("Description 1");

        Epic epic2 = new Epic();
        epic2.setId(2L);
        epic2.setTitle("Epic 2");
        epic2.setDescription("Description 2");

        List<Epic> epics = Arrays.asList(epic1, epic2);
        when(epicService.getAllEpics()).thenReturn(epics);

        // Act
        List<Epic> result = epicController.getAllEpics();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(epic1, result.get(0));
        assertEquals(epic2, result.get(1));
        verify(epicService, times(1)).getAllEpics();
    }

    @Test
    void testGetEpicById() {
        // Arrange
        Long epicId = 1L;
        Epic epic = new Epic();
        epic.setId(epicId);
        epic.setTitle("Test Epic");
        epic.setDescription("Test Description");

        when(epicService.getEpicById(epicId)).thenReturn(epic);

        // Act
        Epic result = epicController.getEpicById(epicId);

        // Assert
        assertNotNull(result);
        assertEquals(epicId, result.getId());
        assertEquals("Test Epic", result.getTitle());
        assertEquals("Test Description", result.getDescription());
        verify(epicService, times(1)).getEpicById(epicId);
    }

    @Test
    void testCreateEpic() {
        // Arrange
        Epic newEpic = new Epic();
        newEpic.setTitle("New Epic");
        newEpic.setDescription("New Description");

        Epic savedEpic = new Epic();
        savedEpic.setId(1L);
        savedEpic.setTitle("New Epic");
        savedEpic.setDescription("New Description");

        when(epicService.createEpic(newEpic)).thenReturn(savedEpic);

        // Act
        Epic result = epicController.createEpic(newEpic);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Epic", result.getTitle());
        assertEquals("New Description", result.getDescription());
        verify(epicService, times(1)).createEpic(newEpic);
    }

    @Test
    void testUpdateEpic() {
        // Arrange
        Long epicId = 1L;
        Epic updatedEpic = new Epic();
        updatedEpic.setTitle("Updated Epic");
        updatedEpic.setDescription("Updated Description");

        Epic savedEpic = new Epic();
        savedEpic.setId(epicId);
        savedEpic.setTitle("Updated Epic");
        savedEpic.setDescription("Updated Description");

        when(epicService.updateEpic(epicId, updatedEpic)).thenReturn(savedEpic);

        // Act
        Epic result = epicController.updateEpic(epicId, updatedEpic);

        // Assert
        assertNotNull(result);
        assertEquals(epicId, result.getId());
        assertEquals("Updated Epic", result.getTitle());
        assertEquals("Updated Description", result.getDescription());
        verify(epicService, times(1)).updateEpic(epicId, updatedEpic);
    }

    @Test
    void testDeleteEpic() {
        // Arrange
        Long epicId = 1L;
        when(epicService.deleteEpic(epicId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = epicController.deleteEpic(epicId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(epicService, times(1)).deleteEpic(epicId);
    }
} 