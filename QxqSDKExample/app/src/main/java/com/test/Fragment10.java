package com.test;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.qxq.base.QxqBaseFragment;
import com.qxq.login_share.QxqLoginShareCallBack;
import com.qxq.login_share.QxqLoginShareUtil;
import com.qxq.login_share.SHARE_TYPE;
import com.qxq.utils.QxqLogUtil;
import com.qxq.utils.QxqToastUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/2/20.
 */
public class Fragment10 extends QxqBaseFragment {

    @Bind(R.id.list)
    ListView listView;

    private List<String> lists = new ArrayList<>();

    @Override
    protected int setContentView() {
        return R.layout.fragment10;
    }

    @Override
    protected void initData() {
        lists.add("分享文字到QQ");
        lists.add("分享图片到QQ");
        lists.add("分享网页到QQ");
        lists.add("分享文字到QZone");
        lists.add("分享图片到QZone");
        lists.add("分享网页到QZone");
        lists.add("分享文字到微信好友");
        lists.add("分享图片到微信好友");
        lists.add("分享网页到微信好友");
        lists.add("分享文字到微信朋友圈");
        lists.add("分享图片到微信朋友圈");
        lists.add("分享网页到微信朋友圈");
    }

    @Override
    public void initLayout(View view) {
        ButterKnife.bind(this,view);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_expandable_list_item_1,lists));
    }

    @Override
    public void initListener(View view) {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i < 3){
                    if(i == 0){
                        QxqLoginShareUtil.onBind(getActivity()).shareToText(SHARE_TYPE.QQ, "content",callBack);
                    }else if(i == 1){
                        QxqLoginShareUtil.onBind(getActivity()).shareToImage(SHARE_TYPE.QQ, "content",R.drawable.ic_launcher,callBack);
                    }else{
                        QxqLoginShareUtil.onBind(getActivity()).shareToUrl(SHARE_TYPE.QQ,"http://www.baidu.com/","title" ,"content",R.drawable.ic_launcher,callBack);
                    }
                }else if(i >= 3 && i < 6){
                    if(i == 3){
                        QxqLoginShareUtil.onBind(getActivity()).shareToText(SHARE_TYPE.QZONE, "content",callBack);
                    }else if(i == 4){
                        QxqLoginShareUtil.onBind(getActivity()).shareToImage(SHARE_TYPE.QZONE, "content",R.drawable.ic_launcher,callBack);
                    }else{
                        QxqLoginShareUtil.onBind(getActivity()).shareToUrl(SHARE_TYPE.QZONE,"http://www.baidu.com/","title" ,"content",R.drawable.ic_launcher,callBack);
                    }
                }else if(i >= 6 && i < 9){
                    if(i == 6){
                        QxqLoginShareUtil.onBind(getActivity()).shareToText(SHARE_TYPE.WEIXIN, "content",callBack);
                    }else if(i == 7){
                        QxqLoginShareUtil.onBind(getActivity()).shareToImage(SHARE_TYPE.WEIXIN, "content",R.drawable.ic_launcher,callBack);
                    }else{
                        QxqLoginShareUtil.onBind(getActivity()).shareToUrl(SHARE_TYPE.WEIXIN,"http://www.baidu.com/","title" ,"content","http://www.qulishi.com/uploads/news/201702/1487728206653495.jpg",callBack);

                    }
                }else if(i >= 9 && i < 12){
                    if(i == 9){
                        QxqLoginShareUtil.onBind(getActivity()).shareToText(SHARE_TYPE.WEIXIN_CIRCLE, "content",callBack);
                    }else if(i == 10){
                        QxqLoginShareUtil.onBind(getActivity()).shareToImage(SHARE_TYPE.WEIXIN_CIRCLE, "content",R.drawable.ic_launcher,callBack);
                    }else{
                        QxqLoginShareUtil.onBind(getActivity()).shareToUrl(SHARE_TYPE.WEIXIN_CIRCLE,"http://www.baidu.com/","title" ,"content",R.drawable.ic_launcher,callBack);
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    QxqLoginShareCallBack callBack = new QxqLoginShareCallBack() {
        @Override
        public void onError(String error) {
            QxqToastUtil.getInstance(getActivity()).showLongToast(error);
        }

        @Override
        public void onCancel(String str) {
            QxqToastUtil.getInstance(getActivity()).showLongToast(str);
        }

        @Override
        public void onStart(String str) {
            QxqToastUtil.getInstance(getActivity()).showLongToast(str);
        }

        @Override
        public void onComplete(String json) {
            QxqToastUtil.getInstance(getActivity()).showLongToast(json);
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        QxqLoginShareUtil.onBind(getActivity()).release();
    }
}
