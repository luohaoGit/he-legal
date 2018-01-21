package com.github.legal.service.impl;

import com.github.legal.domain.Push;
import com.github.legal.mapper.ArticleMapper;
import com.github.legal.mapper.PushMapper;
import com.github.legal.param.PushReq;
import com.github.legal.service.PushService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by luohao on 21/01/2018.
 */
@Service
public class PushServiceImpl implements PushService {

    @Autowired
    private PushMapper pushMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Push> list(PushReq req) {

        if(req.getPaged()){
            PageHelper.startPage(req.getPageNo(), req.getPageSize());
        }

        List<Push> list = pushMapper.list(req);

        if(list != null){
            list.forEach(p -> p.setArticles(articleMapper.queryByPushId(p.getId())));
        }

        return list;
    }

}
