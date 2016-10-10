package com.simontse.gankio.gankioexample.view.viewHolder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.simontse.gankio.gankioexample.R;
import com.simontse.gankio.gankioexample.entity.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by simon_pc on 2016/10/10.
 * Email: xiejx_op@foxmail.com
 * Description:
 */

public class TextVH extends BaseViewHolder<Result> {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_type)
    TextView tvType;

    public TextVH(ViewGroup parent) {
        super(parent, R.layout.item_text);

        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(Result data) {
        super.setData(data);

        tvTitle.setText(data.getDesc());
        tvAuthor.setText(data.getWho());
        tvTime.setText(data.getPublishedAt().split("T")[0]);
        tvType.setText(data.getType());

    }
}
