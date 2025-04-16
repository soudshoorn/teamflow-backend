package com.teamflow.teamflow_backend.repositories;

import com.teamflow.teamflow_backend.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChannelId(Long channelId);
}