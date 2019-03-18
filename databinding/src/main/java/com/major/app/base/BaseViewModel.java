package com.major.app.base;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app
 * ProjectName: dagger2
 * Date: 2019/3/18 10:56
 */
public class BaseViewModel<T extends BaseActivity> {

    protected T mActivity;

    public BaseViewModel(T t) {
        mActivity = t;
    }


}
