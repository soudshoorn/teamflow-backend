package com.teamflow.teamflow_backend.services;

import com.teamflow.teamflow_backend.models.Channel;
import com.teamflow.teamflow_backend.repositories.ChannelRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    public ChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    public Channel createChannel(Channel channel) {
        // Eventueel: controleer of er al een kanaal met dezelfde naam bestaat
        return channelRepository.save(channel);
    }

    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    public Optional<Channel> getChannelById(Long id) {
        return channelRepository.findById(id);
    }

    // Toevoegen van updateChannel methode
    public Channel updateChannel(Long id, Channel updatedChannel) {
        return channelRepository.findById(id).map(existingChannel -> {
            existingChannel.setName(updatedChannel.getName());
            existingChannel.setDescription(updatedChannel.getDescription());
            return channelRepository.save(existingChannel);
        }).orElseThrow(() ->
            new ResponseStatusException(HttpStatus.NOT_FOUND, "Kanaal niet gevonden")
        );
    }

    // Toevoegen van deleteChannel methode
    public void deleteChannel(Long id) {
        if (!channelRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Kanaal niet gevonden");
        }
        channelRepository.deleteById(id);
    }
}