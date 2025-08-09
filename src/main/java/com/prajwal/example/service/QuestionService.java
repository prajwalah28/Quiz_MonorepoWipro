package com.prajwal.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.prajwal.example.entities.Question;
import com.prajwal.example.enums.Category;
import com.prajwal.example.exception.ResourceNotFoundException;
import com.prajwal.example.repos.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private static final Logger logger = LoggerFactory.getLogger(QuestionService.class);

    private final QuestionRepository questionRepository;

    public List<Question> getQuestionsByCategory(Category category) {
        logger.info("Fetching questions for category: {}", category);
        return questionRepository.findByCategory(category);
    }

    public Question addQuestion(Question question) {
        logger.info("Adding new question: {}", question.getQuestionTitle());
        return questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        logger.info("Attempting to delete question with ID: {}", id);

        if (questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
            logger.info("✅ Successfully deleted question with ID: {}", id);
        } else {
            logger.error("❌ Question not found with ID: {}", id);
            throw new ResourceNotFoundException("Question not found with ID: " + id);
        }
    }
}
