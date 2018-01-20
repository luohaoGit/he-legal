package com.github.legal.heapi;

import com.github.legal.common.bean.HeAccessToken;
import com.github.legal.common.util.http.apache.ApacheHttpClientBuilder;

import java.util.concurrent.locks.Lock;

/**
 * @author luohao on 2018/1/19 0019 下午 14:05
 * 配置
 */
public interface HeConfig {

    String getAccessToken();

    boolean isAccessTokenExpired();

    String getAppId();

    String getSecret();

    boolean autoRefreshToken();

    void updateAccessToken(HeAccessToken accessToken);

    void updateAccessToken(String accessToken, int expiresInSeconds);

    Lock getAccessTokenLock();

    String getIp();

    int getPort();

    String getPath();

    String getUrlPrefix();

    ApacheHttpClientBuilder getApacheHttpClientBuilder();

    String getHttpProxyHost();

    int getHttpProxyPort();

    String getHttpProxyUsername();

    String getHttpProxyPassword();

}
