package com.example.mtbs.entity;

import com.example.mtbs.enums.ScreenType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "screen")
public class Screen
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "screen_id",updatable = false,nullable = false)
    private String screeId;

    @Column(name = "screen_type",updatable = false,nullable = false)
    @Enumerated(EnumType.STRING)
    private ScreenType screenType;

    @Column(name = "capacity")
    private Integer capacity;

    @Column(name = "no_of_rows")
    private Integer noOfRows;

    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated",updatable = false)
    private Instant updatedAt;

    @Column(name = "created_by")
    @CreatedBy
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @OneToMany(mappedBy = "screen")
    private List<Seat> seats;
}
