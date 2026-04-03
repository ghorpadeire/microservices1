package com.question.controller;

import com.question.entities.Question;
import com.question.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    //create
    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.create(question);
    }

    //getAll
    @GetMapping
    public List<Question> getAll() {
        return questionService.get();
    }

    //getOne
    @GetMapping("/qusetionId")
    public Question getOne(@PathVariable Long questionId) {
        return questionService.getOne(questionId);
    }

    // get all question of specific quiz
    @GetMapping("/quiz/{quizId}")
    public List<Question> getQestionOfQuiz(@PathVariable Long quizId) {
        return questionService.getQuestionsOfQuizId(quizId);

    }
}
