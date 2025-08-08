package com.prajwal.example.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prajwal.example.entities.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
