package com.example.mtbs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

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

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreatedDate
    private Instant createdAt;

    @JoinColumn(name = "screen_id")
    @ManyToOne
    private Screen screen;


}
