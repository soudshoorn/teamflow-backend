package com.teamflow.teamflow_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String content;

    // Sender wordt hier als verplicht beschouwd, pas aan indien nodig
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_id")
    private User sender;

    // Als de Epic wordt verwijderd, wordt de referentie in Message op null gezet
    @ManyToOne(optional = true)
    @JoinColumn(name = "epic_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Epic epic;

    // Als de UserStory wordt verwijderd, wordt de referentie in Message op null gezet
    @ManyToOne(optional = true)
    @JoinColumn(name = "user_story_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private UserStory userStory;

    // Als de Task wordt verwijderd, wordt de referentie in Message op null gezet
    @ManyToOne(optional = true)
    @JoinColumn(name = "task_id", nullable = true)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Task task;

    private Long timestamp;
}