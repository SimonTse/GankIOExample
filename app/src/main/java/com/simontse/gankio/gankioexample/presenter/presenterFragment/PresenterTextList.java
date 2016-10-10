package com.simontse.gankio.gankioexample.presenter.presenterFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jude.beam.expansion.list.BeamListFragmentPresenter;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.simontse.gankio.gankioexample.entity.Result;
import com.simontse.gankio.gankioexample.model.ListModel;
import com.simontse.gankio.gankioexample.view.activity.ActivityWeb;
import com.simontse.gankio.gankioexample.view.fragment.FragmentListText;

import rx.functions.Action0;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class PresenterTextList extends BeamListFragmentPresenter<FragmentListText,Result> implements RecyclerArrayAdapter.OnItemClickListener{

    private String title;

    @Override
    protected void onCreate(FragmentListText view, Bundle savedState) {
        super.onCreate(view, savedState);

        Bundle bundle = view.getArguments();
        title = bundle.getString("title");

    }


    @Override
    protected void onCreateView(@NonNull FragmentListText view) {
        super.onCreateView(view);
        onRefresh();
        getAdapter().setOnItemClickListener(this);
    }

    @Override
    public void onRefresh() {

        setCurPage(1);
        ListModel.getInstance().getResult(title, 20, getCurPage()).doAfterTerminate(new Action0() {
            @Override
            public void call() {
                setCurPage(2);
            }
        }).unsafeSubscribe(getRefreshSubscriber());

    }

    @Override
    public void onLoadMore() {

        ListModel.getInstance().getResult(title, 20, getCurPage()).unsafeSubscribe(getMoreSubscriber());

    }

    @Override
    public void onItemClick(int position) {
        startActivityWithData(getAdapter().getItem(position),ActivityWeb.class);

    }
}
