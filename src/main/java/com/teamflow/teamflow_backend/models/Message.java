package com.teamflow.teamflow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne(optional = true)
    @JoinColumn(name = "epic_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Epic epic;

    @ManyToOne(optional = true)
    @JoinColumn(name = "user_story_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private UserStory userStory;

    @ManyToOne(optional = true)
    @JoinColumn(name = "task_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Task task;

    @ManyToOne(optional = false)
    @JoinColumn(name = "channel_id", nullable = false)
    private Channel channel;

    private Long timestamp;
}