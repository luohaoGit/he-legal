package com.github.legal.mapper;

import com.github.legal.domain.Article;

import java.util.List;

public interface ArticleMapper {

    List<Article> queryByPushId(Integer pushId);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKey(Article record);
}