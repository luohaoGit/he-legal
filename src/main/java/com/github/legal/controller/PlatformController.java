package com.github.legal.controller;

import com.alibaba.fastjson.JSON;
import com.github.legal.param.CommonResp;
import com.github.legal.util.Coder;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.TreeMap;

/**
 * Created by luohao on 26/01/2018.
 */
@RestController
@RequestMapping(value = "platform")
public class PlatformController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    private static String urlPrefix = "http://121.41.62.98:9200/educloud_new/";
    private static String clientId = "";
    private static String appKey = "";

    private CloseableHttpClient httpClient = HttpClients.custom().build();

    @GetMapping
    public String platform(@RequestParam(name = "app_grant_type") String appGrantType,
                           @RequestParam(name = "code", required = false) String code,
                           @RequestParam(name = "access_token", required = false) String accessToken,
                           @RequestParam(name = "open_id", required = false) String openId,
                           @RequestParam(name = "scope", required = false) String scope,
                           @RequestParam(name = "expires_in", required = false) String expiresIn,
                           @RequestParam(name = "state") String state,
                           @RequestParam(name = "sig") String sig,
                           @RequestParam(name = "error", required = false) String error) throws Exception{

        if(error != null){
            logger.error("发生错误====" + error);
            return null;
        }

        if(StringUtils.isNotEmpty(code)){
            logger.info("收到code====" + code);
            TreeMap<String, String> map = new TreeMap<>();
            map.put("client_id", clientId);
            map.put("code", code);
            map.put("state", System.currentTimeMillis() + "");

            String paramStr = generateParamWithSig(map);

            HttpGet httpGet = new HttpGet(urlPrefix + "ucenter/oauth?" + paramStr);
            try {
                CloseableHttpResponse response = httpClient.execute(httpGet);
                String resultContent = new BasicResponseHandler().handleResponse(response);
                logger.info("获得结果====" + resultContent);
            } catch (Exception e){
                logger.error("error====", e);
            } finally {
                httpGet.releaseConnection();
            }
        }else{
            TreeMap<String, String> map = new TreeMap<>();
            map.put("access_token", accessToken);
            map.put("open_id", openId);
            map.put("client_id", clientId);
            map.put("state", System.currentTimeMillis() + "");

            String paramStr = generateParamWithSig(map);

            HttpGet httpGet = new HttpGet(urlPrefix + "api/openAPI/v3/get_user_info?" + paramStr);
            try {
                CloseableHttpResponse response = httpClient.execute(httpGet);
                String resultContent = new BasicResponseHandler().handleResponse(response);
                CommonResp resp = JSON.parseObject(resultContent, CommonResp.class);

                if(resp.getError() != null){
                    throw new RuntimeException("发生错误====" + resp.getError());
                }

                accessToken = resp.getAccess_token();
                openId = resp.getOpen_id();

                logger.info("获得openId和accessToken====" + openId + "；" + accessToken);

            } catch (Exception e){
                logger.error("error====", e);
            } finally {
                httpGet.releaseConnection();
            }

        }

        return null;
    }

    private String generateParamWithSig(TreeMap<String, String> map) throws Exception{

        String paramStr = map.keySet().stream().reduce("", (acc, item) -> acc += item + "=" + map.get(item) + "&");
        String sigSeed = map.keySet().stream().reduce("", (acc, item) -> acc += item + "=" + map.get(item));

        String sig = new BigInteger(Coder.encryptHMAC((sigSeed).getBytes("utf-8"), appKey)).toString();

        return paramStr + "sig=";
    }

}
