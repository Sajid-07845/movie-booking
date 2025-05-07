package com.example.mtbs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "feedback")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Feedback
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "feedback_id",nullable = false)
    private String feedbackId;

    @Column(name = "rating",nullable = false)
    private int rating;

    @Column(name = "review")
    private String review;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movies;

    @CreatedDate
    @Column(name = "created_at",nullable = false,updatable = false)
    private Instant createdAt;

}
