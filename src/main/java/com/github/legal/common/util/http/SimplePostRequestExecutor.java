package com.github.legal.common.util.http;

import com.github.legal.common.util.http.apache.ApacheSimplePostRequestExecutor;

/**
 * @author luohao on 2018/1/19 0019 下午 13:56
 */
public abstract class SimplePostRequestExecutor<C, P> implements RequestExecutor<String, String> {

    protected RequestHttp<C, P> requestHttp;

    public SimplePostRequestExecutor(RequestHttp requestHttp) {
        this.requestHttp = requestHttp;
    }

    public static RequestExecutor<String, String> create(RequestHttp requestHttp) {
        switch (requestHttp.getRequestType()) {
            case APACHE_HTTP:
                return new ApacheSimplePostRequestExecutor(requestHttp);
            default:
                return null;
        }
    }
}
