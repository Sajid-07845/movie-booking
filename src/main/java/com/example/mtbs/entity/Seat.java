package com.example.mtbs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "seat")
public class Seat
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "seat_id",nullable = false,updatable = false)
    private String seatId;

    @CreatedDate
    private Instant createdAt;


    @Column(name = "created_at",updatable = false,nullable = false)
    @CreatedDate
    private Instant createdAt;

    @JoinColumn(name = "screen_id")
    @ManyToOne
    private Screen screen;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "name")
    private String name;


}
