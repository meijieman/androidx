package com.major.androidx.mvvm;

import android.app.Application;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.androidx.mvvm
 * ProjectName: androidx
 * Date: 2019/3/8 18:24
 */
public class LoginViewModel extends AndroidViewModel /*implements LifecycleObserver*/ {

    private MutableLiveData<Object> mPreLogin = new MutableLiveData<>();
    private MutableLiveData<Boolean> mLoading = new MutableLiveData<>(); // true 开始加载， false 加载完成
    private MutableLiveData<String> mSuccess = new MutableLiveData<>();
    private MutableLiveData<String> mFailure = new MutableLiveData<>();


    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Object> preLogin() {
        return mPreLogin;
    }

    public void login(String usr, String pwd) {
        // 调用预登陆
        preLogin().setValue(null);

        new Thread(() -> {
            SystemClock.sleep(400);
            loading().postValue(true);
            SystemClock.sleep(2000);
            loading().postValue(false);
            if (System.currentTimeMillis() % 2 == 0) {
                // 调用登录成功
                onSuccess().postValue("登录成功！");
            } else {
                onFailure().postValue("登录失败。");
            }

        }).start();
    }


    public MutableLiveData<Boolean> loading() {
        return mLoading;

    }

    public MutableLiveData<String> onSuccess() {
        return mSuccess;

    }

    public MutableLiveData<String> onFailure() {
        return mFailure;
    }

}
