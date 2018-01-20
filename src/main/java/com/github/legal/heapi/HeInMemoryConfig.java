package com.github.legal.heapi;

import com.github.legal.common.bean.HeAccessToken;
import com.github.legal.common.util.http.apache.ApacheHttpClientBuilder;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author luohao on 2018/1/19 0019 下午 15:19
 */
public class HeInMemoryConfig implements HeConfig {

    protected volatile String appId;
    protected volatile String secret;
    protected volatile String accessToken;
    protected volatile long expiresTime;

    protected volatile String ip;
    protected volatile int port;
    protected volatile String path;

    protected volatile String httpProxyHost;
    protected volatile int httpProxyPort;
    protected volatile String httpProxyUsername;
    protected volatile String httpProxyPassword;

    protected volatile ApacheHttpClientBuilder apacheHttpClientBuilder;

    protected Lock accessTokenLock = new ReentrantLock();

    @Override
    public String getAccessToken() {
        return this.accessToken;
    }

    @Override
    public boolean isAccessTokenExpired() {
        return System.currentTimeMillis() > this.expiresTime;
    }

    @Override
    public String getAppId() {
        return this.appId;
    }

    @Override
    public String getSecret() {
        return this.secret;
    }

    @Override
    public boolean autoRefreshToken() {
        return false;
    }

    @Override
    public void updateAccessToken(HeAccessToken accessToken) {
        updateAccessToken(accessToken.getAccessToken(), accessToken.getExpiresIn());
    }

    @Override
    public void updateAccessToken(String accessToken, int expiresInSeconds) {
        this.accessToken = accessToken;
        this.expiresTime = System.currentTimeMillis() + (expiresInSeconds - 200) * 1000L;
    }

    @Override
    public Lock getAccessTokenLock() {
        return this.accessTokenLock;
    }

    @Override
    public String getIp() {
        return this.ip;
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public String getUrlPrefix() {
        return "http://" + this.ip + ":" + this.port + "/" + this.path;
    }

    @Override
    public ApacheHttpClientBuilder getApacheHttpClientBuilder() {
        return this.apacheHttpClientBuilder;
    }

    @Override
    public String getHttpProxyHost() {
        return this.httpProxyHost;
    }

    @Override
    public int getHttpProxyPort() {
        return this.httpProxyPort;
    }

    @Override
    public String getHttpProxyUsername() {
        return this.httpProxyUsername;
    }

    @Override
    public String getHttpProxyPassword() {
        return this.httpProxyPassword;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setExpiresTime(long expiresTime) {
        this.expiresTime = expiresTime;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
