package com.yexue.android.rrxjava.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by admin on 2017/7/6.
 */

public class HttpConn extends Thread {
    String picStr;
    CallBack callBack;
    private Handler handler;

    public HttpConn(String picStr, Handler handler, CallBack callBack) {
        this.picStr = picStr;
        this.callBack = callBack;
        this.handler = handler;
    }

    @Override
    public void run() {
        URL imgUrl = null;
        try {
            imgUrl = new URL(picStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            /*取得联机*/
            HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
            conn.connect();
            /*取得回传的InputStream*/
            InputStream is = conn.getInputStream();
            /*将InputStream转化为Bitmap*/
            final Bitmap bitmap = BitmapFactory.decodeStream(is);
            //用Handler post()方法通知主线程
            handler.post(new Runnable() {
                @Override
                public void run() {
                    callBack.onCompleted(bitmap);
                }
            });
             /*关闭InputStream*/
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface CallBack {
        public void onCompleted(Bitmap bitmap);
    }
}
