package com.major.androidx;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.androidx
 * ProjectName: androidx
 * Date: 2019/3/7 17:24
 */
public class LifeCycleExample implements LifecycleObserver {

    private static final String TAG = "LifeCycleExample";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    void create() {
        Log.i(TAG, "create");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        Log.i(TAG, "start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        Log.i(TAG, "stop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    void any() {
        Log.i(TAG, "any");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    void resume() {
        Log.i(TAG, "resume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pause() {
        Log.i(TAG, "pause");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void destroy() {
        Log.i(TAG, "destroy");
    }


}
