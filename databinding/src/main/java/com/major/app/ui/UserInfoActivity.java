package com.major.app.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.major.app.BR;
import com.major.app.R;
import com.major.app.adapter.CommonAdapter;
import com.major.app.base.BaseActivity;
import com.major.app.databinding.ActivityUserInfoBinding;
import com.major.app.model.HobbyViewModel;
import com.major.app.model.UserInfoViewModel;

/**
 */
public class UserInfoActivity extends BaseActivity {

    private ActivityUserInfoBinding mUserInfoBinding;
    private UserInfoViewModel mUserInfoViewModel;

    private CommonAdapter<HobbyViewModel> mHobbiesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_info);
        mUserInfoViewModel = new UserInfoViewModel(this);
        mUserInfoBinding.setUserInfoViewModel(mUserInfoViewModel);

        mUserInfoBinding.hobbyRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mHobbiesAdapter = new CommonAdapter<>(R.layout.list_item_hobby, BR.hobbyViewModel);
        mUserInfoBinding.hobbyRecyclerView.setAdapter(mHobbiesAdapter);

        mUserInfoViewModel.loadUserInfo();
    }
}
