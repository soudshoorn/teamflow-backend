package com.teamflow.teamflow_backend.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import java.util.Set;

class ChannelTest {

    @Test
    void testChannelCreation() {
        // Arrange
        String name = "Test Channel";
        String description = "This is a test channel";
        
        // Act
        Channel channel = Channel.builder()
                .name(name)
                .description(description)
                .build();
        
        // Assert
        assertNotNull(channel);
        assertEquals(name, channel.getName());
        assertEquals(description, channel.getDescription());
        assertNotNull(channel.getMessages());
        assertTrue(channel.getMessages().isEmpty());
    }

    @Test
    void testChannelWithMessages() {
        // Arrange
        String name = "Test Channel";
        Set<Message> messages = new HashSet<>();
        
        // Create a sender
        User sender = new User();
        sender.setId(1L);
        sender.setUsername("testuser");
        
        // Create messages with required fields
        Message message1 = new Message();
        message1.setContent("Message 1");
        message1.setSender(sender);
        message1.setTimestamp(System.currentTimeMillis());
        
        Message message2 = new Message();
        message2.setContent("Message 2");
        message2.setSender(sender);
        message2.setTimestamp(System.currentTimeMillis());
        
        messages.add(message1);
        messages.add(message2);
        
        // Act
        Channel channel = Channel.builder()
                .name(name)
                .messages(messages)
                .build();
        
        // Set the channel reference in the messages
        message1.setChannel(channel);
        message2.setChannel(channel);
        
        // Assert
        assertNotNull(channel);
        assertEquals(name, channel.getName());
        assertEquals(2, channel.getMessages().size());
        assertTrue(channel.getMessages().contains(message1));
        assertTrue(channel.getMessages().contains(message2));
    }

    @Test
    void testChannelSetters() {
        // Arrange
        Channel channel = new Channel();
        String name = "New Channel";
        String description = "New Description";
        Set<Message> messages = new HashSet<>();
        Message message = new Message();
        messages.add(message);
        
        // Act
        channel.setName(name);
        channel.setDescription(description);
        channel.setMessages(messages);
        
        // Assert
        assertEquals(name, channel.getName());
        assertEquals(description, channel.getDescription());
        assertEquals(1, channel.getMessages().size());
        assertTrue(channel.getMessages().contains(message));
    }
} 