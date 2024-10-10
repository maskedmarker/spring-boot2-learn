package org.example.learn.spring.boot.commons.model.util;

import org.example.learn.spring.boot.commons.model.base.BaseResponseData;
import org.example.learn.spring.boot.commons.model.constant.ErrorCodeConstants;

public class ResponseUtils {

    public static final String OK_MESSAGE = "OK";

    public static <T> BaseResponseData<T> ok(T data) {
        return new BaseResponseData<>(ErrorCodeConstants.OK, OK_MESSAGE, data);
    }
}
