package com.github.legal.service;

import com.github.legal.domain.Answer;
import com.github.legal.domain.Question;
import com.github.legal.param.AnswerReq;
import com.github.legal.param.QuestionReq;

import java.util.List;

/**
 * Created by luohao on 21/01/2018.
 */
public interface QuestionService {

    List<Question> list(QuestionReq req);

    List<Answer> queryByQuestionId(AnswerReq answerReq);
}
