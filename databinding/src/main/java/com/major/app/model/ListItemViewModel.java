package com.major.app.model;

import com.major.app.base.BaseActivity;
import com.major.app.base.BaseViewModel;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app.model
 * ProjectName: dagger2
 * Date: 2019/3/18 11:24
 */
public class ListItemViewModel<T extends BaseActivity> extends BaseViewModel<T> {


    public ListItemViewModel(T t) {
        super(t);
    }


}
