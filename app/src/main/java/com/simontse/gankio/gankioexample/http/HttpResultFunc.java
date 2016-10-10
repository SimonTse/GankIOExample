package com.simontse.gankio.gankioexample.http;

import com.simontse.gankio.gankioexample.entity.GanHuo;

import rx.functions.Func1;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description:用来统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
 * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
 */

public class HttpResultFunc<T> implements Func1<GanHuo<T>,T> {

    @Override
    public T call(GanHuo<T> tGanHuo) {

        if (tGanHuo.isError()) {
            throw new ApiException("服务器返回错误");
        }

        return tGanHuo.getResults();
    }
}
