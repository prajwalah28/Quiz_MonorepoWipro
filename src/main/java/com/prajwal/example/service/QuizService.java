package com.prajwal.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.prajwal.example.entities.Question;
import com.prajwal.example.entities.QuestionWrapper;
import com.prajwal.example.entities.Quiz;
import com.prajwal.example.entities.Response;
import com.prajwal.example.exception.ResourceNotFoundException;
import com.prajwal.example.repos.QuestionRepository;
import com.prajwal.example.repos.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {

	private final QuizRepository quizRepository;
	private final QuestionRepository questionRepository;

	
	public Quiz createQuiz(String category, String level,  String title) {
	    List<Question> questions = questionRepository.findRandomQuestionsByCategoryAndLevel(category, level);

	    Quiz quiz = new Quiz();
	    quiz.setTitle(title);
	    quiz.setQuestions(questions);

	    return quizRepository.save(quiz);
	}




	    public List<QuestionWrapper> getQuizQuestions(Integer id) {
	    	
	    	 Quiz quiz = quizRepository.findById(id)
	    		        .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with ID: " + id));

	    		    List<Question> questionsFromDB = quiz.getQuestions();
	    		    List<QuestionWrapper> questionsForUser = new ArrayList<>();

	    		    for (Question q : questionsFromDB) {
	    		        QuestionWrapper qw = new QuestionWrapper(q.getQuestionID(), q.getQuestionTitle(),
	    		                q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
	    		        questionsForUser.add(qw);
	    		    }

	    		    return questionsForUser;

	    }



		
	    public Integer calculateResult(int id, List<Response> responses) {
y
	    }
	
	
}
