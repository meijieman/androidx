package com.major.androidx;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.major.androidx.mvvm.LoginViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

/**
 * 实现 MVVM 架构
 */
public class Main3Activity extends AppCompatActivity {

    private EditText mUsr;
    private EditText mPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        mUsr = findViewById(R.id.et_usr);
        mPwd = findViewById(R.id.et_pwd);

        LoginViewModel model = ViewModelProviders.of(this).get(LoginViewModel.class);


        findViewById(R.id.btn_login).setOnClickListener((v) -> {
            model.login(mUsr.getText().toString(), mPwd.getText().toString());
        });

//        Lifecycle lifecycle = getLifecycle();
//        lifecycle.addObserver(model);


        model.preLogin().observe(this, o -> {
            // 登录前的操作


        });

        model.loading().observe(this, b->{
            if (b) {
                // 加载中

            } else {
                // 加载完成

            }
        });


        model.onFailure().observe(this, s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        });
        model.onSuccess().observe(this, s -> {
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        });



    }
}
