package com.example.mtbs.repository;

import com.example.mtbs.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,String>
{

}
