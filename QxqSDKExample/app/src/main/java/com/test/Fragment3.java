package com.test;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Environment;
import android.view.View;

import com.qxq.base.QxqBaseFragment;
import com.qxq.http.OnHttpCallBackListener;
import com.qxq.http.QxqHttpUtil;
import com.qxq.utils.QxqDialogUtil;
import com.qxq.utils.QxqLogUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/3.
 */
public class Fragment3 extends QxqBaseFragment {

    FileOutputStream stream = null;

    @Override
    protected int setContentView() {
        return R.layout.fragment3;
    }

    @Override
    protected void initData() {
        try {
            String pathName="/sdcard/test/";
            String fileName="女生小说.txt";
            File path = new File(pathName);
            File file = new File(pathName + fileName);
            if( !path.exists()) {
                path.mkdir();
            }
            if( !file.exists()) {
                file.createNewFile();
            }
            stream = new FileOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initLayout(View view) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QxqHttpUtil.getInstance().get("",
                        new OnHttpCallBackListener() {
                            @Override
                            public void onComplete(String json) {
                                QxqLogUtil.getInstance().i("TAG","json..."+json);
                            }

                            @Override
                            public void onError(String error) {
                                QxqLogUtil.getInstance().i("TAG","error..."+error);
                            }
                        });
            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QxqHttpUtil.getInstance().post("", new HashMap<String, String>(), new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.getInstance().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.getInstance().i("TAG","error..."+error);
                    }
                });
            }
        });

        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                QxqHttpUtil.getInstance().postToJson("your url", "your json", new OnHttpCallBackListener() {
                    @Override
                    public void onComplete(String json) {
                        QxqLogUtil.getInstance().i("TAG","json..."+json);
                    }

                    @Override
                    public void onError(String error) {
                        QxqLogUtil.getInstance().i("TAG","error..."+error);
                    }
                });
            }
        });
    }

    @Override
    public void initListener(View view) {

    }

    @Override
    public void onClick(View view) {

    }

}
