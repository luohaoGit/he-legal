package com.github.legal.heapi.impl;

import com.github.legal.common.bean.HeAccessToken;
import com.github.legal.common.bean.result.HeError;
import com.github.legal.common.exception.HeErrorException;
import com.github.legal.common.util.http.HttpType;
import com.github.legal.common.util.http.apache.ApacheHttpClientBuilder;
import com.github.legal.common.util.http.apache.DefaultApacheHttpClientBuilder;
import com.github.legal.heapi.HeConfig;
import com.github.legal.heapi.HeService;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.util.concurrent.locks.Lock;

/**
 * @author luohao on 2018/1/19 0019 上午 11:09
 */
public class HeServiceApacheHttpClientImpl extends HeServiceAbstractImpl<CloseableHttpClient, HttpHost> {

    private CloseableHttpClient httpClient;
    private HttpHost httpProxy;

    @Override
    public CloseableHttpClient getRequestHttpClient() {
        return httpClient;
    }

    @Override
    public HttpHost getRequestHttpProxy() {
        return httpProxy;
    }

    @Override
    public HttpType getRequestType() {
        return HttpType.APACHE_HTTP;
    }

    @Override
    public void initHttp() {
        HeConfig config = this.getConfig();
        ApacheHttpClientBuilder apacheHttpClientBuilder = config.getApacheHttpClientBuilder();
        if (null == apacheHttpClientBuilder) {
            apacheHttpClientBuilder = DefaultApacheHttpClientBuilder.get();
        }

        apacheHttpClientBuilder.httpProxyHost(config.getHttpProxyHost())
                .httpProxyPort(config.getHttpProxyPort())
                .httpProxyUsername(config.getHttpProxyUsername())
                .httpProxyPassword(config.getHttpProxyPassword());

        if (config.getHttpProxyHost() != null && config.getHttpProxyPort() > 0) {
            this.httpProxy = new HttpHost(config.getHttpProxyHost(), config.getHttpProxyPort());
        }

        this.httpClient = apacheHttpClientBuilder.build();
    }

    @Override
    public String getAccessToken(boolean forceRefresh) throws HeErrorException {
        HeConfig config = this.getConfig();
        Lock lock = config.getAccessTokenLock();
        try {
            lock.lock();
            if (config.isAccessTokenExpired() || forceRefresh) {
                String url = String.format(HeService.GET_ACCESS_TOKEN_URL, config.getAppId(), config.getSecret());
                try {
                    HttpGet httpGet = new HttpGet(url);
                    if (this.getRequestHttpProxy() != null) {
                        RequestConfig requestConfig = RequestConfig.custom().setProxy(this.getRequestHttpProxy()).build();
                        httpGet.setConfig(requestConfig);
                    }
                    try (CloseableHttpResponse response = getRequestHttpClient().execute(httpGet)) {
                        String resultContent = new BasicResponseHandler().handleResponse(response);
                        HeError error = HeError.fromJson(resultContent);
                        if (error.getRet() != 0) {
                            throw new HeErrorException(error);
                        }
                        HeAccessToken accessToken = HeAccessToken.fromJson(resultContent);
                        config.updateAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn());
                    } finally {
                        httpGet.releaseConnection();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } finally {
            lock.unlock();
        }
        return config.getAccessToken();
    }
}
