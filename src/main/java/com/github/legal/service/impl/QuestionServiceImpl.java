package com.github.legal.service.impl;

import com.github.legal.domain.Answer;
import com.github.legal.domain.Question;
import com.github.legal.mapper.AnswerMapper;
import com.github.legal.mapper.QuestionMapper;
import com.github.legal.param.AnswerReq;
import com.github.legal.param.QuestionReq;
import com.github.legal.service.QuestionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luohao on 21/01/2018.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Override
    public List<Question> list(QuestionReq req) {

        if(req.getPaged()){
            PageHelper.startPage(req.getPageNo(), req.getPageSize());
        }

        return questionMapper.list(req);
    }

    @Override
    public List<Answer> queryByQuestionId(AnswerReq req) {

        if(req.getPaged()){
            PageHelper.startPage(req.getPageNo(), req.getPageSize());
        }

        return answerMapper.queryByQuestionId(req.getQuestionId());
    }

}
