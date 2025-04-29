package com.example.mtbs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Seat
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String seatId;

    @CreatedDate
    private Instant createdAt;

    @ManyToOne
    private Screen screen;

    @Column(name = "is_delete")
    private Boolean isDelete;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "name")
    private String name;


}
