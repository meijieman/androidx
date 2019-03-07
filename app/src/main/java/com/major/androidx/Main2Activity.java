package com.major.androidx;

import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";

    private LiveDataTimerViewModel mLiveDataTimerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Chronometer chronometer = findViewById(R.id.chronometer);
        chronometer.start();
//        chronometer.setBase(System.currentTimeMillis());
        chronometer.setFormat("开始计时：%s");

        Chronometer chronometer2 = findViewById(R.id.chronometer2);

        mLiveDataTimerViewModel = ViewModelProviders.of(this).get(LiveDataTimerViewModel.class);
        mLiveDataTimerViewModel.getElapsedTime().observe(this, aLong -> {
            chronometer2.setText("计时 " + aLong);
            Log.d(TAG, "Updating timer aLong " + aLong);
        });

        getLifecycle().addObserver(new LifeCycleExample());

        LiveDataExample liveData = new LiveDataExample();
        liveData.observe(this, s -> Log.d(TAG, "onChanged s " + s));
        liveData.observe(this, s -> Log.d(TAG, "onChanged2 s " + s));

        // TODO: 2019/3/7 如何移除当个 observer ?

    }
}
