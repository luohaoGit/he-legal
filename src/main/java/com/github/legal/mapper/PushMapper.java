package com.github.legal.mapper;

import com.github.legal.domain.Push;

public interface PushMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Push record);

    int insertSelective(Push record);

    Push selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Push record);

    int updateByPrimaryKey(Push record);
}