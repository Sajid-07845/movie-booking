package com.example.mtbs.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class User extends UserDetails
{
    @OneToMany(mappedBy ="user")
    private List<Feedback> feedbacks;
}
