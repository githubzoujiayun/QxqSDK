package com.test;

import android.app.ProgressDialog;
import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.login_share.QxqLoginShareCallBack;
import com.qxq.login_share.QxqLoginShareUtil;
import com.qxq.utils.QxqDialogUtil;
import com.qxq.utils.QxqLogUtil;

/**
 * Created by Administrator on 2017/2/20.
 */
public class Fragment9 extends QxqBaseFragment {
    @Override
    protected int setContentView() {
        return R.layout.fragment9;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void initLayout(View view) {

    }

    @Override
    public void initListener(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(this);
        view.findViewById(R.id.btn2).setOnClickListener(this);
    }

    private  ProgressDialog dilaog;

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                dilaog = QxqDialogUtil.getInstance().progressDialog().setMessage("正在获取用户信息...").showProgressDialog(getActivity());
                QxqLoginShareUtil.onBind(getActivity()).loginToQQ(new QxqLoginShareCallBack() {
                    @Override
                    public void onError(String error) {
                        dilaog.dismiss();
                    }

                    @Override
                    public void onCancel(String str) {
                        dilaog.dismiss();
                    }

                    @Override
                    public void onStart(String str) {

                    }

                    @Override
                    public void onComplete(String json) {
                        dilaog.dismiss();
                        QxqLogUtil.getInstance().i("json",json);
                    }
                });
                break;
            case R.id.btn2:
                dilaog = QxqDialogUtil.getInstance().progressDialog().setMessage("正在获取用户信息...").showProgressDialog(getActivity());
                QxqLoginShareUtil.onBind(getActivity()).loginToWeiXin(new QxqLoginShareCallBack() {
                    @Override
                    public void onError(String error) {
                        dilaog.dismiss();
                        QxqLogUtil.getInstance().i("ERROR",error+"===");
                    }

                    @Override
                    public void onCancel(String str) {
                        dilaog.dismiss();
                    }

                    @Override
                    public void onStart(String str) {

                    }

                    @Override
                    public void onComplete(String json) {
                        dilaog.dismiss();
                        QxqLogUtil.getInstance().i("json",json+"---");
                    }
                });
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        QxqLoginShareUtil.onBind(getActivity()).release();
    }
}
