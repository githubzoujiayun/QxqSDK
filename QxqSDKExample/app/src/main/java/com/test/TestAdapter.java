package com.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.qxq.base.QxqBaseRecyclerViewAdapter;
import com.qxq.base.adapter_base.OnRecyclerViewListener;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TestAdapter extends QxqBaseRecyclerViewAdapter {

    private Context mContext;
    public TestAdapter(Context context) {
        super(context);
        mContext =  context;
    }

    @Override
    public RecyclerView.ViewHolder getHolder(ViewGroup parent) {
        return new TestHolder(mContext, parent,R.layout.item1,onRecyclerViewListener);
    }

    private OnRecyclerViewListener onRecyclerViewListener;

    public void setOnRecyclerViewListener(OnRecyclerViewListener onRecyclerViewListener) {
        this.onRecyclerViewListener = onRecyclerViewListener;
    }


}
