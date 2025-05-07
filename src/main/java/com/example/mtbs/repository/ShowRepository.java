package com.example.mtbs.repository;

import com.example.mtbs.entity.Screen;
import com.example.mtbs.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;

public interface ShowRepository extends JpaRepository<Show,String>
{

    @Query(value = "SELECT CASE WHEN COUNT(*) > 0 THEN true ELSE false END " +
            "FROM `show` s " + // Use backticks to escape 'show' as it's a reserved keyword
            "WHERE s.screen_id = :screenId " + // Use the correct column name for screenId
            "AND s.starts_at < :endTime " +
            "AND s.ends_at > :startTime",
            nativeQuery = true)
    Boolean existsByScreenAndStartTimeLessThanAndEndTimeGreaterThan(
            @Param("screenId") String screenId, // Assuming screenId is of type Long or similar
            @Param("startTime") Instant startTime,
            @Param("endTime") Instant endTime);
}