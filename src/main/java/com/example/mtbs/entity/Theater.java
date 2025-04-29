package com.example.mtbs.entity;

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
@EntityListeners(AuditingEntityListener.class)
@Setter
@Getter
@Table(name = "theater")
public class Theater
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "theater_id",nullable = false,updatable = false)
    private String theaterId;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(name = "city",nullable = false)
    private String city;

    @Column(name = "landmark",nullable = false)
    private String landmark;

    @JoinColumn(name = "theater_owner_id")
    @ManyToOne
    private TheaterOwner theaterOwner;

    @Column(name = "created_at",updatable = false,nullable = false)
    @CreatedDate
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    @Column(name = "created_by",updatable = false,nullable = false)
    @CreatedBy
    private String createdBy;

    @OneToMany(mappedBy = "theater")
    private List<Screen> screen;


}
