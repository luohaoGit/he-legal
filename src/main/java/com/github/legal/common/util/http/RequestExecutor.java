package com.github.legal.common.util.http;

import com.github.legal.common.exception.HeErrorException;

import java.io.IOException;

/**
 * @author luohao on 2018/1/19 0019 上午 10:08
 */
public interface RequestExecutor<R, D> {

    /**
     * @param uri  uri
     * @param data 数据
     * @throws HeErrorException
     * @throws IOException
     */
    R execute(String uri, D data) throws HeErrorException, IOException;

}
