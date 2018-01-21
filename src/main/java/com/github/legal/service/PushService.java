package com.github.legal.service;

import com.github.legal.domain.Push;
import com.github.legal.param.PushReq;

import java.util.List;

/**
 * Created by luohao on 21/01/2018.
 */
public interface PushService {

    List<Push> list(PushReq req);

}
