package com.github.legal.heapi.impl;

import com.github.legal.common.exception.HeErrorException;
import com.github.legal.common.util.http.RequestExecutor;
import com.github.legal.common.util.http.RequestHttp;
import com.github.legal.common.util.http.SimpleGetRequestExecutor;
import com.github.legal.common.util.http.SimplePostRequestExecutor;
import com.github.legal.heapi.HeConfig;
import com.github.legal.heapi.HeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author luohao on 2018/1/19 0019 上午 9:46
 */
public abstract class HeServiceAbstractImpl<C, P> implements HeService, RequestHttp<C, P> {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    protected HeConfig config;

    private int retrySleepMillis = 1000;
    private int maxRetryTimes = 5;

    @Override
    public String getAccessToken() throws HeErrorException {
        return getAccessToken(false);
    }

    @Override
    public String get(String url, String queryParam) throws HeErrorException {
        return execute(SimpleGetRequestExecutor.create(this), url, queryParam);
    }

    @Override
    public String post(String url, String postData) throws HeErrorException {
        return execute(SimplePostRequestExecutor.create(this), url, postData);
    }

    @Override
    public <R, D> R execute(RequestExecutor<R, D> executor, String uri, D data) throws HeErrorException {

        return null;
    }

    public <R, D> R executeInternal(RequestExecutor<R, D> executor, String uri, D data) throws HeErrorException {

        try {
            R result = executor.execute(uri, data);
            this.log.debug("\n【请求地址】: {}\n【请求参数】：{}\n【响应数据】：{}", uri, data, result);
            return result;
        } catch (HeErrorException e){
            //todo do sth.
        } catch (IOException e) {
            this.log.error("\n【请求地址】: {}\n【请求参数】：{}\n【异常信息】：{}", uri, data, e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public HeConfig getConfig() {
        return this.config;
    }

}
