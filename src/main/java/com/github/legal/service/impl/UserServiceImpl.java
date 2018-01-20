package com.github.legal.service.impl;

import com.github.legal.domain.User;
import com.github.legal.mapper.UserMapper;
import com.github.legal.param.UserReq;
import com.github.legal.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luohao on 20/01/2018.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list(UserReq userReq) {
        PageHelper.startPage(1, 1);
        return userMapper.list(userReq);
    }

}
