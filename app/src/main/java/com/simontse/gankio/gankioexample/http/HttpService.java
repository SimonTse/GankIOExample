package com.simontse.gankio.gankioexample.http;

import com.simontse.gankio.gankioexample.entity.GanHuo;
import com.simontse.gankio.gankioexample.entity.Result;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:  api 接口
 */

public interface HttpService {
    //分页获取数据
    @GET("data/{type}/{count}/{page}")
    Observable<GanHuo<List<Result>>>  getGanHuo(
            @Path("type") String type,
            @Path("count") int count,
            @Path("page") int page
            );

}
