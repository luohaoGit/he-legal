package com.github.legal.controller;

import com.github.legal.domain.User;
import com.github.legal.param.UserReq;
import com.github.legal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luohao on 20/01/2018.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "list")
    public List<User> list(UserReq userReq){
        return userService.list(userReq);
    }

}
