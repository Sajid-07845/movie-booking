package com.example.mtbs.repository;

import com.example.mtbs.entity.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails, String>
{

    boolean existsByEmail(String email);

    UserDetails findByEmail(String email);
}
