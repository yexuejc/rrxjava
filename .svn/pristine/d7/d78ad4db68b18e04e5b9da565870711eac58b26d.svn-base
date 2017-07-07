package com.yexue.android.rrxjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.yexue.android.rrxjava.utils.HttpConn;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpActivity extends AppCompatActivity {
    ImageView img;
    Button img_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        img = (ImageView) findViewById(R.id.img);
        img_btn = (Button) findViewById(R.id.img_btn);
        final String picStr = "http://www.shixiu.net/d/file/p/2bc22002a6a61a7c5694e7e641bf1e6e.jpg";
        final Handler handler = new Handler();
        img_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new HttpConn(picStr, handler, new HttpConn.CallBack() {
                    @Override
                    public void onCompleted(Bitmap bitmap) {
                        img.setImageBitmap(bitmap);
                    }
                }).start();
            }
        });
    }


}
