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
        QxqHttpUtil.onBind().setBaseUrl("http://api.1313m.com/");
        QxqLogUtil.init(true);
        QxqToastUtil.init(getApplicationContext());
        QxqDialogUtil.init();
        QxqLoginShareUtil.init(this);
        QxqLoginShareUtil.setQQ("1104911867","vZTng1q5fKbLQI08");
        QxqLoginShareUtil.setWeiXin("wx023daf39180f3578","d4624c36b6795d1d99dcf0547af5443d");
    }
}
