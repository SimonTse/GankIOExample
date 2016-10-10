package com.simontse.gankio.gankioexample.view.fragment;

import android.view.ViewGroup;

import com.jude.beam.bijection.RequiresPresenter;
import com.jude.beam.expansion.list.BeamListFragment;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.simontse.gankio.gankioexample.entity.Result;
import com.simontse.gankio.gankioexample.presenter.presenterFragment.PresenterImageList;
import com.simontse.gankio.gankioexample.view.viewHolder.ImageVH;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simon_pc on 2016/10/9.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

@RequiresPresenter(PresenterImageList.class)
public class FragmentListImage extends BeamListFragment<PresenterImageList, Result> {

    List<Integer> mHeights = new ArrayList<>();

    @Override
    public BaseViewHolder getViewHolder(ViewGroup parent, int viewType) {
        return new ImageVH(parent,mHeights);
    }
}
