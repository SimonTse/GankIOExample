package com.simontse.gankio.gankioexample.http;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description: 接口返回数据用于处理异常，详见Rxjava与Retrofit的最佳实践一文
 */

public class ApiException extends RuntimeException {

    public ApiException(int resultCode) {
        this(getApiExceptionMessage(resultCode));

    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    /**
     * 由于服务器传递过来的错误信息直接给用户看的话，用户未必能够理解
     * 需要根据错误码对错误信息进行一个转换，再显示给用户
     * @param resultCode
     * @return
     */
    private static String getApiExceptionMessage(int resultCode) {

        String message = "";
        //Todo.... 可以做一下判断

        return  message;

    }

}
