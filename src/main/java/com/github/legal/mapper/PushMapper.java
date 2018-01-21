package com.github.legal.mapper;

import com.github.legal.domain.Push;
import com.github.legal.param.PushReq;

import java.util.List;

public interface PushMapper {

    List<Push> list(PushReq req);

    int deleteByPrimaryKey(Integer id);

    int insert(Push record);

    int insertSelective(Push record);

    Push selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Push record);

    int updateByPrimaryKey(Push record);
}