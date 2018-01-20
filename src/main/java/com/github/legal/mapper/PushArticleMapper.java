package com.github.legal.mapper;

import com.github.legal.domain.PushArticle;

public interface PushArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PushArticle record);

    int insertSelective(PushArticle record);

    PushArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PushArticle record);

    int updateByPrimaryKey(PushArticle record);
}