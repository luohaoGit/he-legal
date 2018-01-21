package com.github.legal.controller;

import com.github.legal.domain.Answer;
import com.github.legal.domain.Question;
import com.github.legal.param.AnswerReq;
import com.github.legal.param.QuestionReq;
import com.github.legal.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luohao on 21/01/2018.
 */
@RestController
@RequestMapping(value = "question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping(value = "list")
    public List<Question> list(QuestionReq req){
        return questionService.list(req);
    }

    @GetMapping(value = "answers")
    public List<Answer> answers(AnswerReq req){
        return questionService.queryByQuestionId(req);
    }

}
