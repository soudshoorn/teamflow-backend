package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.Message;
import com.teamflow.teamflow_backend.services.MessageService;
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
class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

    @Test
    void testGetAllMessages() {
        // Arrange
        Message message1 = new Message();
        message1.setId(1L);
        message1.setContent("Message 1");

        Message message2 = new Message();
        message2.setId(2L);
        message2.setContent("Message 2");

        List<Message> messages = Arrays.asList(message1, message2);
        when(messageService.getAllMessages()).thenReturn(messages);

        // Act
        List<Message> result = messageController.getAllMessages();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(message1, result.get(0));
        assertEquals(message2, result.get(1));
        verify(messageService, times(1)).getAllMessages();
    }

    @Test
    void testGetMessageById() {
        // Arrange
        Long messageId = 1L;
        Message message = new Message();
        message.setId(messageId);
        message.setContent("Test Message");

        when(messageService.getMessageById(messageId)).thenReturn(message);

        // Act
        Message result = messageController.getMessageById(messageId);

        // Assert
        assertNotNull(result);
        assertEquals(messageId, result.getId());
        assertEquals("Test Message", result.getContent());
        verify(messageService, times(1)).getMessageById(messageId);
    }

    @Test
    void testGetMessagesByChannel() {
        // Arrange
        Long channelId = 1L;
        Message message1 = new Message();
        message1.setId(1L);
        message1.setContent("Message 1");

        Message message2 = new Message();
        message2.setId(2L);
        message2.setContent("Message 2");

        List<Message> messages = Arrays.asList(message1, message2);
        when(messageService.getAllMessagesByChannel(channelId)).thenReturn(messages);

        // Act
        List<Message> result = messageController.getMessagesByChannel(channelId);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(message1, result.get(0));
        assertEquals(message2, result.get(1));
        verify(messageService, times(1)).getAllMessagesByChannel(channelId);
    }

    @Test
    void testCreateMessage() {
        // Arrange
        Message newMessage = new Message();
        newMessage.setContent("New Message");

        Message savedMessage = new Message();
        savedMessage.setId(1L);
        savedMessage.setContent("New Message");

        when(messageService.createMessage(newMessage)).thenReturn(savedMessage);

        // Act
        Message result = messageController.createMessage(newMessage);

        // Assert
        assertNotNull(result);
        assertEquals(1L, result.getId());
        assertEquals("New Message", result.getContent());
        verify(messageService, times(1)).createMessage(newMessage);
    }

    @Test
    void testUpdateMessage() {
        // Arrange
        Long messageId = 1L;
        Message updatedMessage = new Message();
        updatedMessage.setContent("Updated Message");

        Message savedMessage = new Message();
        savedMessage.setId(messageId);
        savedMessage.setContent("Updated Message");

        when(messageService.updateMessage(messageId, updatedMessage)).thenReturn(savedMessage);

        // Act
        Message result = messageController.updateMessage(messageId, updatedMessage);

        // Assert
        assertNotNull(result);
        assertEquals(messageId, result.getId());
        assertEquals("Updated Message", result.getContent());
        verify(messageService, times(1)).updateMessage(messageId, updatedMessage);
    }

    @Test
    void testDeleteMessage() {
        // Arrange
        Long messageId = 1L;
        when(messageService.deleteMessage(messageId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = messageController.deleteMessage(messageId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(messageService, times(1)).deleteMessage(messageId);
    }
} 