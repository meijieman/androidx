package com.major.app.model;

import android.databinding.ObservableField;

import com.major.app.ui.FriendListActivity;
import com.major.app.R;
import com.major.app.base.BaseViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app.model
 * ProjectName: dagger2
 * Date: 2019/3/18 11:13
 */
public class FriendListViewModel extends BaseViewModel<FriendListActivity> {

    public ObservableField<List<FriendViewModel>> mFriendListViewModel = new ObservableField<>();

    public FriendListViewModel(FriendListActivity activity) {
        super(activity);
    }

    public void loadFriendList() {
        List<FriendViewModel> friends = new ArrayList<>();
        friends.addAll(requestData());
        mFriendListViewModel.set(friends);
    }

    private List<FriendViewModel> requestData() {
        List<FriendViewModel> data = new ArrayList<>();
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "张三", "打南边来了个喇嘛"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "李四", "手里提着五斤鳎蚂"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "王五", "打北边来了一个哑巴"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "赵四", "腰里别着一个喇叭"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "刘能", "提搂鳎蚂的喇嘛要拿鳎蚂去换别着喇叭的哑巴的喇叭"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "大脚", "别着喇叭的哑巴不愿意拿喇叭去换提搂鳎蚂的喇嘛的鳎蚂"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "芙蓉", "提搂鳎蚂的喇嘛抡起鳎蚂就给了别着喇叭的哑巴一鳎蚂"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "秀才", "别着喇叭的哑巴抽出喇叭就给了提搂鳎蚂的喇嘛一喇叭"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "掌柜", "也不知是提搂鳎蚂的喇嘛打了别着喇叭的哑巴"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "大嘴", "还是别着喇叭的哑巴打了提搂鳎蚂的喇嘛"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "展堂", "喇嘛回家炖鳎蚂"));
        data.add(new FriendViewModel(mActivity).setData(R.drawable.head_image_01, "小六", "哑巴回家滴滴答答吹喇叭"));
        return data;
    }
}
