package com.teamflow.teamflow_backend.controllers;

import com.teamflow.teamflow_backend.models.Channel;
import com.teamflow.teamflow_backend.services.ChannelService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/channels")
@CrossOrigin
public class ChannelController {

    private final ChannelService channelService;

    public ChannelController(ChannelService channelService) {
        this.channelService = channelService;
    }

    @PostMapping
    public Channel createChannel(@RequestBody Channel channel) {
        return channelService.createChannel(channel);
    }

    @GetMapping
    public List<Channel> getAllChannels() {
        return channelService.getAllChannels();
    }

    @GetMapping("/{id}")
    public Channel getChannelById(@PathVariable Long id) {
        return channelService.getChannelById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Kanaal niet gevonden"));
    }
    
    @PutMapping("/{id}")
    public Channel updateChannel(@PathVariable Long id, @RequestBody Channel updatedChannel) {
        return channelService.updateChannel(id, updatedChannel);
    }

    @DeleteMapping("/{id}")
    public void deleteChannel(@PathVariable Long id) {
        channelService.deleteChannel(id);
    }
}