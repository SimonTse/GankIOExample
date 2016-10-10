package com.simontse.gankio.gankioexample.view.fragment;

import android.os.Bundle;
import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.simontse.gankio.gankioexample.entity.Result;
import com.simontse.gankio.gankioexample.presenter.presenterFragment.PresenterTextList;
import com.simontse.gankio.gankioexample.view.viewHolder.TextVH;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

@RequiresPresenter(PresenterTextList.class)
public class FragmentListText  extends BeamListFragment<PresenterTextList,Result>{
    @Override
    public BaseViewHolder  getViewHolder(ViewGroup parent, int viewType) {
        return new TextVH(parent);
    }

    public static FragmentListText getInstance(String title) {

        FragmentListText fragmentListText = new FragmentListText();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        fragmentListText.setArguments(bundle);
        return fragmentListText;

    }

}
