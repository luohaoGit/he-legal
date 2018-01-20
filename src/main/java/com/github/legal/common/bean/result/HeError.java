package com.github.legal.common.bean.result;

import com.github.legal.common.util.json.HeGsonBuilder;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * @author luohao on 2018/1/19 0019 上午 10:02
 */
@Data
@Builder
public class HeError implements Serializable{

    private static final long serialVersionUID = 7869786563361406291L;

    private int ret;

    private String msg;

    public static HeError fromJson(String json) {
        return HeGsonBuilder.create().fromJson(json, HeError.class);
    }

    @Override
    public String toString() {
        return "错误: Code=" + this.ret + ", Msg=" + this.msg;
    }

}
