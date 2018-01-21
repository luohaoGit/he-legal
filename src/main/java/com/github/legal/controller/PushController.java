package com.github.legal.controller;

import com.github.legal.domain.Push;
import com.github.legal.param.PushReq;
import com.github.legal.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by luohao on 21/01/2018.
 */
@RestController
@RequestMapping(value = "push")
public class PushController {

    @Autowired
    private PushService pushService;

    @GetMapping(value = "list")
    public List<Push> list(PushReq req){
        return  pushService.list(req);
    }

}
