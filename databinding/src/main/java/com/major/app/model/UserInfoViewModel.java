package com.major.app.model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.major.app.ui.UserInfoActivity;
import com.major.app.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app
 * ProjectName: dagger2
 * Date: 2019/3/18 10:54
 */
public class UserInfoViewModel extends BaseViewModel<UserInfoActivity> {

    public ObservableField<String> headImageUrl = new ObservableField<>();

    public ObservableField<String> name = new ObservableField<>();

    public ObservableInt age = new ObservableInt();

    public ObservableField<String> job = new ObservableField<>();

    public ObservableField<List<HobbyViewModel>> hobbies = new ObservableField<>();

    public UserInfoViewModel(UserInfoActivity activity) {
        super(activity);
    }

    public void loadUserInfo() {
        headImageUrl.set("https://avatar.csdn.net/6/F/7/1_u011002668.jpg?1523959103");
        name.set("朱小明");
        age.set(21);
        job.set("三山街贴膜");

        List<HobbyViewModel> list = new ArrayList<>();
        HobbyViewModel model1 = new HobbyViewModel("爬树");
        HobbyViewModel model2 = new HobbyViewModel("吃被门夹过的核桃");
        HobbyViewModel model3 = new HobbyViewModel("把头伸进微波炉");
        list.add(model1);
        list.add(model2);
        list.add(model3);
        hobbies.set(list);
    }
}
