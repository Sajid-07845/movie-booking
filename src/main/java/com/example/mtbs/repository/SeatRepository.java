package com.example.mtbs.repository;

import com.example.mtbs.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,String>
{

}
