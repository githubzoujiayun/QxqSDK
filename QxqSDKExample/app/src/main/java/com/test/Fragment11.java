package com.test;

import android.view.View;
import android.widget.ImageView;

import com.qxq.base.QxqBaseFragment;
import com.qxq.glide.utils.QxqGlideType;
import com.qxq.glide.utils.QxqILoader;
import com.qxq.glide.utils.QxqGlideLoaderUtil;

/**
 * Created by Administrator on 2017/3/2.
 */
public class Fragment11 extends QxqBaseFragment {

    @Override
    protected int setContentView() {
        return R.layout.fragment11;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initLayout(View view) {
        ImageView image = (ImageView) view.findViewById(R.id.image);
        ImageView image1 = (ImageView) view.findViewById(R.id.image1);
        ImageView image2 = (ImageView) view.findViewById(R.id.image2);
        QxqILoader.Options options = new QxqILoader.Options(R.drawable.ic_launcher,R.drawable.ic_launcher, QxqGlideType.ROUND);
        QxqGlideLoaderUtil.getLoader().loadNet(image,
                "http://img.9yaocn.com/attachments/201703/02/10/13tbt9ztt.jpg",
                options);
        QxqGlideLoaderUtil.getLoader().loadNet(image1,
                "http://img.9yaocn.com/attachments/201703/02/10/13s8s8qxw.jpg",
                options);
        QxqGlideLoaderUtil.getLoader().loadNet(image2,
                "http://img.9yaocn.com/attachments/201703/02/10/13s5mx7wn.jpg",
                options);
    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void onClick(View view) {

    }
}
