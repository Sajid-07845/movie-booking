package com.example.mtbs.entity;

import com.example.mtbs.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Setter
@Getter
public class UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Long createdAt;
    private Long updatedAt;
//    private boolean isDeleted
}
