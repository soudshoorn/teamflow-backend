package com.teamflow.teamflow_backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testMessageCreation() {
        // Arrange
        String content = "Test message content";
        User sender = new User();
        Channel channel = new Channel();
        Long timestamp = System.currentTimeMillis();
        
        // Act
        Message message = Message.builder()
                .content(content)
                .sender(sender)
                .channel(channel)
                .timestamp(timestamp)
                .build();
        
        // Assert
        assertNotNull(message);
        assertEquals(content, message.getContent());
        assertEquals(sender, message.getSender());
        assertEquals(channel, message.getChannel());
        assertEquals(timestamp, message.getTimestamp());
        assertNull(message.getEpic());
        assertNull(message.getUserStory());
        assertNull(message.getTask());
    }

    @Test
    void testMessageWithAllRelations() {
        // Arrange
        String content = "Test message with all relations";
        User sender = new User();
        Channel channel = new Channel();
        Epic epic = new Epic();
        UserStory userStory = new UserStory();
        Task task = new Task();
        Long timestamp = System.currentTimeMillis();
        
        // Act
        Message message = Message.builder()
                .content(content)
                .sender(sender)
                .channel(channel)
                .epic(epic)
                .userStory(userStory)
                .task(task)
                .timestamp(timestamp)
                .build();
        
        // Assert
        assertNotNull(message);
        assertEquals(content, message.getContent());
        assertEquals(sender, message.getSender());
        assertEquals(channel, message.getChannel());
        assertEquals(epic, message.getEpic());
        assertEquals(userStory, message.getUserStory());
        assertEquals(task, message.getTask());
        assertEquals(timestamp, message.getTimestamp());
    }

    @Test
    void testMessageSetters() {
        // Arrange
        Message message = new Message();
        String content = "New content";
        User sender = new User();
        Channel channel = new Channel();
        Epic epic = new Epic();
        UserStory userStory = new UserStory();
        Task task = new Task();
        Long timestamp = System.currentTimeMillis();
        
        // Act
        message.setContent(content);
        message.setSender(sender);
        message.setChannel(channel);
        message.setEpic(epic);
        message.setUserStory(userStory);
        message.setTask(task);
        message.setTimestamp(timestamp);
        
        // Assert
        assertEquals(content, message.getContent());
        assertEquals(sender, message.getSender());
        assertEquals(channel, message.getChannel());
        assertEquals(epic, message.getEpic());
        assertEquals(userStory, message.getUserStory());
        assertEquals(task, message.getTask());
        assertEquals(timestamp, message.getTimestamp());
    }
} 