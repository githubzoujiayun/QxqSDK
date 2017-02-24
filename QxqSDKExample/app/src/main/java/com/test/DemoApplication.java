package com.test;

import android.app.Application;

import com.qxq.http.QxqHttpUtil;
import com.qxq.login_share.QxqLoginShareUtil;
import com.qxq.utils.QxqDialogUtil;
import com.qxq.utils.QxqLogUtil;
import com.qxq.utils.QxqToastUtil;

/**
 * Created by Administrator on 2017/1/5.
 */
public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QxqHttpUtil.initSDK(getApplicationContext());
        QxqHttpUtil.onBind().setBaseUrl("http://XX.XXXX.com/");
        QxqLogUtil.init(true);
        QxqToastUtil.init(getApplicationContext());
        QxqDialogUtil.init();
        QxqLoginShareUtil.init(this);
        QxqLoginShareUtil.setQQ("app_id","app_key");
        QxqLoginShareUtil.setWeiXin("app_id","app_secret");
    }
}
