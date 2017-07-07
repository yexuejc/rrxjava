package com.yexue.android.rrxjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private static String tag = "MainActivityLOG";

    TextView te;
    Button toMap, toHttp, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        te = (TextView) findViewById(R.id.te);
        toMap = (Button) findViewById(R.id.toMap);
        toHttp = (Button) findViewById(R.id.toHttp);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);

        method0();
        toMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapActivity.class));
            }
        });
        toHttp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HttpActivity.class));
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ActionActivity.class));
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TestActivity.class));
            }
        });
    }

    public void method0() {
        /**
         * 观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(tag, "Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, "Error!");
            }

            @Override
            public void onNext(String s) {
                Log.d(tag, "Item: " + s);
            }
        };
        /**
         * 订阅内容
         */
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(tag, ">>>Completed!");
            }

            @Override
            public void onError(Throwable e) {
                Log.d(tag, ">>>Error!");
            }

            @Override
            public void onNext(String s) {
                Log.d(tag, ">>>Item: " + s);
            }
        };
        /**
         * 被观察者
         */
        Observable observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello");
                subscriber.onNext("Hi");
                subscriber.onNext("Aloha");
                subscriber.onCompleted();
            }
        });
        //关联订阅
        //订阅观察者的事件
        observable.subscribe(observer);
        //直接订阅事件
        observable.subscribe(subscriber);
    }

    /**
     * 原理
     */
    public void method1() {
        //创建 Observable--被观察者 对象
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("Hello world RxJava");
                subscriber.onCompleted();
            }
        });
        //订阅内容
        Subscriber subscriber = new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {
                te.setText(o.toString());
            }
        };
        //将Observable和Subscriber相关联，即完成subscriber和observable的订阅
        observable.subscribe(subscriber);
    }

    /**
     * 原理
     */
    public void method2() {
        //被观察者
        Observable<String> observable = Observable.just("简化 RXJAVA");
        //订阅
        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                te.setText(s);
            }
        };
        //关联
        observable.subscribe(onNextAction);
    }

    /**
     * 正常写法
     */
    public void method3() {
        Observable.just("更简化 De RxJava").subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                te.setText(s);
            }
        });
    }
}
