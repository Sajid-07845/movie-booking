package com.example.mtbs.entity;

import com.example.mtbs.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
public class Screen
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String screeId;
    @Enumerated(EnumType.STRING)
    private ScreenType screenType;
    private Integer capacity;
    private Integer noOfRows;

    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
    private String createdBy;

    @ManyToOne
    private Theater theater;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
