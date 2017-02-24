package com.test;

import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.utils.QxqToastUtil;
import com.qxq.view_pager.ImageCycleViewListener;
import com.qxq.view_pager.QxqFragmentCycleViewPager;
import com.qxq.view_pager.QxqViewPagerUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/2/17.
 */
public class Fragment8 extends QxqBaseFragment {

    private List<String> datas = new ArrayList<>();

    @Override
    protected int setContentView() {
        return R.layout.fragment8;
    }

    @Override
    protected void initData() {
        datas.add("http://imgsrc.baidu.com/forum/pic/item/a8ec8a13632762d006deaa12a0ec08fa503dc6bf.jpg");
        datas.add("http://upload.art.ifeng.com/2015/0811/1439260959533.jpg");
        datas.add("http://pic2.ooopic.com/12/13/96/42bOOOPICb2_1024.jpg");

    }

    @Override
    public void initLayout(View view) {
        ButterKnife.bind(this,view);
        QxqFragmentCycleViewPager cycleViewPager = (QxqFragmentCycleViewPager)getChildFragmentManager().findFragmentById(R.id.fragment_cycle_viewpager_content);
        QxqViewPagerUtil.onBind()
                .with(cycleViewPager)//添加控件
                .setIsActivity(false)//设置当前是不是在Activity
                .setWheel(true)//设置是否轮播
                .setTime(3000)//设置轮播切换时间(毫秒)
//                .setPointImageRes()//设置切换的点的资源图片
                .setData(datas)//设置数据
                .setImageCycleViewListener(new ImageCycleViewListener() {
                    @Override
                    public void onImageClick(int postion, View imageView) {
                        QxqToastUtil.onBind().showLongToast("第"+(postion + 1)+"个");
                    }
                })
                .show(getActivity());

    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void onClick(View view) {

    }

    @OnClick(R.id.btn)
    void clickBtn(View view){
        startAnimActivity(ViewPagerActivity.class,null,null);
    }

}
