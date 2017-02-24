package com.test;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qxq.base.adapter_base.OnRecyclerViewListener;
import com.qxq.base.adapter_base.QxqBaseViewHolder;

import butterknife.Bind;

/**
 * Created by Administrator on 2017/2/16.
 */
public class TestHolder extends QxqBaseViewHolder {

    @Bind(R.id.name)
    TextView name;
    @Bind(R.id.email)
    TextView email;
    @Bind(R.id.layout)
    LinearLayout layout;


    public TestHolder(Context context,ViewGroup root,   int layoutRes, OnRecyclerViewListener listener) {
        super(context,root, layoutRes, listener);
    }

    @Override
    public void bindData(Object o) {

        TestModel testModel = (TestModel) o;
        name.setText(testModel.getName());
        email.setText(testModel.getEmail());
        layout.setOnClickListener(this);
    }
}
