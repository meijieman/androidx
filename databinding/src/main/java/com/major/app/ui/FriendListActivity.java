package com.major.app.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.major.app.BR;
import com.major.app.adapter.CommonAdapter;
import com.major.app.R;
import com.major.app.base.BaseActivity;
import com.major.app.databinding.ActivityFriendListBinding;
import com.major.app.model.FriendListViewModel;
import com.major.app.model.FriendViewModel;

public class FriendListActivity extends BaseActivity {

    private ActivityFriendListBinding mFriendListBinding;

    private FriendListViewModel mFriendListViewModel;

    private CommonAdapter<FriendViewModel> mFriendsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFriendListBinding = DataBindingUtil.setContentView(this, R.layout.activity_friend_list);

        mFriendListViewModel = new FriendListViewModel(this);
        mFriendListBinding.setFriendListViewModel(mFriendListViewModel);

        mFriendListBinding.friendListRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mFriendListBinding.friendListRecyclerView.addItemDecoration(new VerticalDecoration(this));

        mFriendsAdapter = new CommonAdapter<>(R.layout.list_item_friend, BR.friendViewModel);
        mFriendListBinding.friendListRecyclerView.setAdapter(mFriendsAdapter);

        mFriendListViewModel.loadFriendList();
    }
}
