package com.example.mtbs.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;

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


}
