package com.github.legal.common.util.http;

import com.github.legal.common.util.http.apache.ApacheHttpClientSimpleGetRequestExecutor;

/**
 * @author luohao on 2018/1/19 0019 上午 11:14
 */
public abstract class SimpleGetRequestExecutor<C, P> implements RequestExecutor<String, String> {

    protected RequestHttp<C, P> requestHttp;

    public SimpleGetRequestExecutor(RequestHttp<C, P> requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<String, String> create(RequestHttp requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new ApacheHttpClientSimpleGetRequestExecutor(requestHttp);
            default:
                throw new IllegalArgumentException("非法请求参数");
        }
    }

}
