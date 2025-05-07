package com.example.mtbs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Entity
@Table(name = "movie_show")
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@ToString
public class Show
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "show_id",nullable = false,updatable = false)
    private String showId;

    @Column(name = "starts_at",nullable = false)
    private Instant startsAt;

    @Column(name = "ends_at",nullable = false)
    private Instant endsAt;

    @CreatedDate
    @Column(name = "created_at",updatable = false,nullable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt;

    @CreatedBy
    @Column(name = "created_by",nullable = false)
    private String createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "screen_id")
    private Screen screen;

//    @ManyToOne
//    @JoinColumn(name = "theater_id")
//    private Theater theaters;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;


}
