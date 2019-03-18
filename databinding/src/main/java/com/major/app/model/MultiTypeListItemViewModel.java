package com.major.app.model;

import com.major.app.base.BaseActivity;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app.model
 * ProjectName: dagger2
 * Date: 2019/3/18 11:24
 */
public abstract class MultiTypeListItemViewModel<T extends BaseActivity> extends ListItemViewModel<T> {

    public int mType;

    public MultiTypeListItemViewModel(T activity) {
        super(activity);
    }

    public abstract int variableId();
}
