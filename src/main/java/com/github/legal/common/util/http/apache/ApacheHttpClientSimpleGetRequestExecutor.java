package com.github.legal.common.util.http.apache;

import com.github.legal.common.bean.result.HeError;
import com.github.legal.common.exception.HeErrorException;
import com.github.legal.common.util.http.RequestHttp;
import com.github.legal.common.util.http.SimpleGetRequestExecutor;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;

/**
 * @author luohao on 2018/1/19 0019 上午 11:14
 */
public class ApacheHttpClientSimpleGetRequestExecutor extends SimpleGetRequestExecutor<CloseableHttpClient, HttpHost> {

    public ApacheHttpClientSimpleGetRequestExecutor(RequestHttp requestHttp) {
        super(requestHttp);
    }

    @Override
    public String execute(String uri, String queryParam) throws HeErrorException, IOException {
        if (queryParam != null) {
            if (uri.indexOf('?') == -1) {
                uri += '?';
            }
            uri += uri.endsWith("?") ? queryParam : '&' + queryParam;
        }
        HttpGet httpGet = new HttpGet(uri);
        if (requestHttp.getRequestHttpProxy() != null) {
            RequestConfig config = RequestConfig.custom().setProxy(requestHttp.getRequestHttpProxy()).build();
            httpGet.setConfig(config);
        }

        try (CloseableHttpResponse response = requestHttp.getRequestHttpClient().execute(httpGet)) {
            String responseContent = Utf8ResponseHandler.INSTANCE.handleResponse(response);
            HeError error = HeError.fromJson(responseContent);
            if (error.getRet() != 0) {
                throw new HeErrorException(error);
            }
            return responseContent;
        } finally {
            httpGet.releaseConnection();
        }
    }

}