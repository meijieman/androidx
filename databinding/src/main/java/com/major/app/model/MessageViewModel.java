package com.major.app.model;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.major.app.ui.ChatListActivity;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app.model
 * ProjectName: dagger2
 * Date: 2019/3/18 11:24
 */
public class MessageViewModel extends MultiTypeListItemViewModel<ChatListActivity> {

    public ObservableInt mHeadImgResId = new ObservableInt();

    public ObservableField<String> mNickName = new ObservableField<>();

    public ObservableField<String> mMessage = new ObservableField<>();

    public MessageViewModel(ChatListActivity activity) {
        super(activity);
    }

    @Override
    public int variableId() {
        return 0;
//        return BR.messageViewModel;
    }

    public MessageViewModel setData(int type, int headImgResId, String nickName, String lastMessage) {
        mType = type;
        mHeadImgResId.set(headImgResId);
        mNickName.set(nickName);
        mMessage.set(lastMessage);
        return this;
    }
}
