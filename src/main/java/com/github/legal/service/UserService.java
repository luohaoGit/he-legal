package com.github.legal.service;

import com.github.legal.domain.User;
import com.github.legal.param.UserReq;

import java.util.List;

/**
 * Created by luohao on 20/01/2018.
 */
public interface UserService {

    List<User> list(UserReq userReq);

}
