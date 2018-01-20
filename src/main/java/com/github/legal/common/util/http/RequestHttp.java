package com.github.legal.common.util.http;

/**
 * @author luohao on 2018/1/19 0019 上午 9:42
 */
public interface RequestHttp<C, P> {

    /**
     * 返回httpClient
     */
    C getRequestHttpClient();

    /**
     * 返回httpProxy
     */
    P getRequestHttpProxy();

    HttpType getRequestType();

}
