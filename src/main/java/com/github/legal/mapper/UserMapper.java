package com.github.legal.mapper;

import com.github.legal.domain.User;
import com.github.legal.param.UserReq;

import java.util.List;

public interface UserMapper {

    List<User> list(UserReq userReq);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}