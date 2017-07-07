package com.yexue.android.rrxjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

public class MapActivity extends AppCompatActivity {
    TextView rxmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        rxmap = (TextView) findViewById(R.id.rxmap);
        method2();
       
    }

    /**
     * Observable可以进行数据查询，Subscriber用来显示结果；
     *
     * Observable是屏幕上的点击事件，Subscriber用来响应事件；
     *
     * Observable可以是网络请求，Subscriber用来显示请求结果。
     *
     */
    public void method1(){
        Observable.just("RxJava Map").map(new Func1<String, String>() {

            @Override
            public String call(String str) {
                return str + "map后缀";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                rxmap.setText(s);
            }
        });
    }
    public void method2(){
        Observable.just("map").map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                return s.hashCode();
            }
        }).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer.toString()+"->2th";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                rxmap.setText(s);
            }
        });
    }

}
