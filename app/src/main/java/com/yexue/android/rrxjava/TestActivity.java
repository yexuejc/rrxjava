package com.yexue.android.rrxjava;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

public class TestActivity extends AppCompatActivity {
    private static String log = "TestActivity";

    @BindView(R.id.p1_btn)
    Button p1Btn;
    @BindView(R.id.p1_tv)
    TextView p1Tv;
    @BindView(R.id.p1_btn_c)
    Button p1BtnC;
    @BindView(R.id.p2_btn)
    Button p2Btn;
    @BindView(R.id.p2_btn_c)
    Button p2BtnC;
    @BindView(R.id.p2_img)
    ImageView p2Img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ButterKnife.bind(this);
        p1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                method1();
            }
        });
        p1BtnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p1Tv.setText("");
            }
        });
    }

    /**
     * 将字符串数组 names 中的所有字符串依次打印出来：
     */
    private void method1() {
        String[] names = {"张三", "lisi", "王麻子"};
        Observable.from(names).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                String oldStr = p1Tv.getText().toString();
                p1Tv.setText(oldStr + "\n" + s);
            }
        });
    }

    @OnClick({R.id.p2_btn, R.id.p2_btn_c})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.p2_btn:
                method2(R.mipmap.a);
                break;
            case R.id.p2_btn_c:
                method2(0);
                break;
        }
    }

    private void method2(int a) {
        final int drawableRes = a;//-->改个没有的就会激发onError();
        Observable.create(new Observable.OnSubscribe<Drawable>() {
            @Override
            public void call(Subscriber<? super Drawable> subscriber) {
                Drawable drawable = null;
                drawable = ContextCompat.getDrawable(TestActivity.this, drawableRes);
                subscriber.onNext(drawable);
                subscriber.onCompleted();
            }
        }).subscribe(new Observer<Drawable>() {
            @Override
            public void onCompleted() {
                Log.d(log, "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                Log.d(log, e.getStackTrace().toString());
                Toast.makeText(TestActivity.this, "Error!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(Drawable drawable) {
                p2Img.setImageDrawable(drawable);
            }
        });
    }
}
