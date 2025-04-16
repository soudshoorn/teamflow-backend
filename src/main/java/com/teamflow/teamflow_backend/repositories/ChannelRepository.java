package com.teamflow.teamflow_backend.repositories;

import com.teamflow.teamflow_backend.models.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Long> {
    // Bijvoorbeeld: zoeken op kanaalnaam
    Channel findByName(String name);
}