package com.simontse.gankio.gankioexample.http;

import com.simontse.gankio.gankioexample.config.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 5;

    public static HttpService  httpService;

    public static HttpService getService() {
        if (httpService == null) {
            createService();
        }
        return httpService;
    }

    private static void createService() {

        httpService = createRetrofit().create(HttpService.class);
    }

    private static Retrofit createRetrofit() {
        //手动创建一个OkHttpClient并设置超时时间
        OkHttpClient.Builder  builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor  loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(loggingInterceptor);

        return new Retrofit.Builder()
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build();

    }

    public static<T> void  toSubscribe(Observable<T> o, Subscriber<T> s) {

        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);

    }


}
