package com.prajwal.example.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prajwal.example.entities.Question;
import com.prajwal.example.enums.Category;
import com.prajwal.example.service.QuestionService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
public class QuestionController {

	
	private final QuestionService questionService;


	
    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable Category category){
        return questionService.getQuestionsByCategory(category);
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestBody Question question){
        return  questionService.addQuestion(question);
    }
	
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestion(id);
        return "Question deleted with ID: " + id;
    }

}
