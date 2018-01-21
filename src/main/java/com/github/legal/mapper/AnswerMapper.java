package com.github.legal.mapper;

import com.github.legal.domain.Answer;

import java.util.List;

public interface AnswerMapper {

    List<Answer> queryByQuestionId(Integer questionId);

    int deleteByPrimaryKey(Integer id);

    int insert(Answer record);

    int insertSelective(Answer record);

    Answer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Answer record);

    int updateByPrimaryKey(Answer record);
}