package com.major.app.model;

import android.databinding.ObservableField;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app
 * ProjectName: dagger2
 * Date: 2019/3/18 10:56
 */
public class HobbyViewModel {

    public ObservableField<String> strObs = new ObservableField<>();


    public HobbyViewModel(String str) {
        strObs.set(str);
    }
}
