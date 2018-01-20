package com.github.legal.common.exception;

import com.github.legal.common.bean.result.HeError;

/**
 * @author luohao on 2018/1/19 0019 上午 9:50
 */
public class HeErrorException extends Exception {

    private static final long serialVersionUID = -6357149550353160810L;

    private HeError error;

    public HeErrorException(HeError error) {
        super(error.toString());
        this.error = error;
    }

    public HeErrorException(HeError error, Throwable cause) {
        super(error.toString(), cause);
        this.error = error;
    }

    public HeError getError() {
        return this.error;
    }

}
