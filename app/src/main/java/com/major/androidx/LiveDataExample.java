package com.major.androidx;

import android.os.SystemClock;
import android.util.Log;

import java.util.Calendar;

import androidx.lifecycle.LiveData;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.androidx
 * ProjectName: androidx
 * Date: 2019/3/7 18:31
 */
public class LiveDataExample extends LiveData<String> {

    private static final String TAG = "LiveDataExample";

    // 当LiveData对象有一个活跃的Observer时，onActive()方法被调用。
    @Override
    protected void onActive() {
        Log.i(TAG, "onActive");
        new Thread(()->{
            // 有注册监听时，调用业务逻辑，使用 postValue 返回结果
            for (int i = 0; i < 25; i++) {
                SystemClock.sleep(1000);
                postValue("数据来啦  " + Calendar.getInstance().getTime().toLocaleString());
            }
        }).start();
    }

    // 当LiveData对象没有任何活跃的Observer时，onInactive()方法被调用。
    // 没有活跃对象，即当处于 pause 或没有注册 observer
    @Override
    protected void onInactive() {
        Log.i(TAG, "onInactive");
    }
}
