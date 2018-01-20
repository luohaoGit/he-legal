package com.github.legal.heapi;

import com.github.legal.common.exception.HeErrorException;
import com.github.legal.common.util.http.RequestExecutor;

/**
 * @author luohao on 2018/1/19 0019 上午 9:37
 */
public interface HeService {

    String GET_ACCESS_TOKEN_URL = "ucenter/oauth?grant_type=refresh_token&client_id=%s&refresh_token=%s";

    String getAccessToken() throws HeErrorException;

    String getAccessToken(boolean forceRefresh) throws HeErrorException;

    HeConfig getConfig();

    void initHttp();

    String get(String url, String queryParam) throws HeErrorException;

    String post(String url, String postData) throws HeErrorException;

    <R,D> R execute(RequestExecutor<R, D> executor, String uri, D data) throws HeErrorException;
}
