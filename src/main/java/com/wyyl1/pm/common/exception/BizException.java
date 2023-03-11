package com.wyyl1.pm.common.exception;

/**
 * 业务异常
 */
public class BizException extends RuntimeException {

    public BizException(String errMsg) {
        super(errMsg);
    }

    public BizException of(String errMsg) {
        return new BizException(errMsg);
    }
}
