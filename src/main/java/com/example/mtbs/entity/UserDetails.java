package com.example.mtbs.entity;

import com.example.mtbs.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Setter
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_details")
public class UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "email",nullable = false,unique = true)
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "user_role",updatable = false,nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @Column(name = "phone_number",updatable = true,length = 10,nullable = false)
    private String phoneNumber;

    @Column(name="date_of_birth",nullable = false)
    private LocalDate dateOfBirth;

    @CreatedDate
    @Column(name = "created_at",nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Instant updatedAt;

    @Column(name = "is_deleted")
    private boolean isDeleted;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    @Column(name="created_by",updatable = false)
    @CreatedBy
    private String createdBy;

}
