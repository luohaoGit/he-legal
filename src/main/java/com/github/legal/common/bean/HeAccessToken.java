package com.github.legal.common.bean;

import com.github.legal.common.util.json.HeGsonBuilder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author luohao on 2018/1/19 0019 下午 16:12
 */
@Data
public class HeAccessToken implements Serializable {

    private static final long serialVersionUID = 8709719312922168909L;

    private String accessToken;

    private int expiresIn = -1;

    public static HeAccessToken fromJson(String json) {
        return HeGsonBuilder.create().fromJson(json, HeAccessToken.class);
    }

}
