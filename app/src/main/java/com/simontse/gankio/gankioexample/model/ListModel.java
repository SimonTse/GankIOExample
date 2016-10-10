package com.simontse.gankio.gankioexample.model;

import com.jude.beam.model.AbsModel;
import com.simontse.gankio.gankioexample.entity.Result;
import com.simontse.gankio.gankioexample.http.HttpMethods;
import com.simontse.gankio.gankioexample.http.HttpResultFunc;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class ListModel extends AbsModel {

    public static ListModel getInstance() {
        return getInstance(ListModel.class);
    }

    public Observable<List<Result>> getResult(String type, int count, int page) {

        return HttpMethods.getService().getGanHuo(type, count, page)
                .map(new HttpResultFunc<List<Result>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }

}
