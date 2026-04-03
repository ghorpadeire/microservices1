package com.question.services;

import com.question.entities.Question;
import com.question.repository.QuestionRespository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class QuestionServiceImpl implements QuestionService {
    private QuestionRespository questionRespository;

    public QuestionServiceImpl(QuestionRespository questionRespository) {
        this.questionRespository = questionRespository;
    }

    @Override
    public Question create(Question question) {
        return  questionRespository.save(question);
    }

    @Override
    public List<Question> get() {
        return questionRespository.findAll();
    }

    @Override
    public Question getOne(Long id) {
        return questionRespository.findById(id).orElseThrow(() -> new RuntimeException("Question Not Found"));
    }

    @Override
    public List<Question> getQuestionsOfQuizId(Long quizId) {
        return questionRespository.findByQuizId(quizId);
    }
}
