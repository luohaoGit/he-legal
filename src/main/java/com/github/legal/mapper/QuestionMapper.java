package com.github.legal.mapper;

import com.github.legal.domain.Question;
import com.github.legal.param.QuestionReq;

import java.util.List;

public interface QuestionMapper {

    List<Question> list(QuestionReq req);

    int deleteByPrimaryKey(Integer id);

    int insert(Question record);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}