package com.yexue.android.rrxjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;

public class ActionActivity extends AppCompatActivity {
    private static String log = "ActionActivityLOG";
    Button action_btn1, action_btn2, action_btn3;


    Observable<String> observable;
    Action0 onCompletedAction;
    Action1<Throwable> onErrorAction;
    Action1<String> onNextAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        action_btn1 = (Button) findViewById(R.id.action_btn1);
        action_btn2 = (Button) findViewById(R.id.action_btn2);
        action_btn3 = (Button) findViewById(R.id.action_btn3);
        method1();
        action_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 自动创建 Subscriber ，并使用 onNextAction 来定义 onNext()
                observable.subscribe(onNextAction);
            }
        });
        action_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 自动创建 Subscriber ，并使用 onNextAction 和 onErrorAction 来定义 onNext() 和 onError()
                observable.subscribe(onNextAction, onErrorAction);
            }
        });
        action_btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 自动创建 Subscriber ，并使用 onNextAction、 onErrorAction 和 onCompletedAction 来定义 onNext()、 onError() 和 onCompleted()
                observable.subscribe(onNextAction, onErrorAction, onCompletedAction);
            }
        });
    }

    /**
     * 除了 subscribe(Observer) 和 subscribe(Subscriber) ，
     * subscribe() 还支持不完整定义的回调，RxJava 会自动根据定义创建出 Subscriber 。形式如下：
     */
    private void method1() {
        //onNext
        onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(log, s);
            }
        };
        //onError
        onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Log.d(log, throwable.getMessage());
            }
        };
        //onCompleted
        onCompletedAction = new Action0() {
            @Override
            public void call() {
                Log.d(log, "onCompletedAction");
            }
        };
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("he");
                subscriber.onCompleted();
                //TODO 未执行onErrorAction，原因未知
                int a[] = {1, 3, 5, 6, 5, 4, 54, 8, 4};
                Log.d(log, a[100] + "");
            }
        });

    }
}
