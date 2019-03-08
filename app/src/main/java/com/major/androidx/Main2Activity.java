package com.major.androidx;

import android.os.Bundle;
import android.util.Log;
import android.widget.Chronometer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
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

        // TODO: 2019/3/7 如何移除单个个 observer ?

        // 转换LiveData
        // map
        LiveData<String> ld = new LiveDataExample();
        LiveData<Integer> ldInt = Transformations.map(ld, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                String substring = input.substring(input.lastIndexOf(":") + 1);
                return Integer.parseInt(substring);
            }
        });
        ldInt.observe(this, i -> Log.d(TAG, "转换后 " + i));

        // switch
        LiveData<Boolean> ldBoolean = Transformations.switchMap(ld, new Function<String, LiveData<Boolean>>() {
            @Override
            public LiveData<Boolean> apply(String input) {
                TransLiveData transLiveData = new TransLiveData(input);
                Log.i(TAG, "switchMap 转换 " + transLiveData);
                return transLiveData;
            }
        });
        ldBoolean.observe(this, b -> Log.d(TAG, "switchMap 转换后 " + b));

    }

    class TransLiveData extends LiveData<Boolean> {

        private String mStr;

        public TransLiveData(String str) {
            mStr = str;
        }

        @Override
        protected void onActive() {
            if (mStr != null) {
                String sub = mStr.substring(mStr.length() - 1);
                setValue(Integer.parseInt(sub) % 2 == 0);
            } else {
                setValue(false);
            }
        }

        @Override
        protected void onInactive() {

        }
    }
}
