## androidx 的使用
```
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.cardview:cardview:1.0.0'
    implementation 'androidx.legacy:legacy-support-v4:1.0.0'
    implementation 'androidx.lifecycle:lifecycle-extensions:2.0.0'
    implementation 'androidx.recyclerview:recyclerview:1.0.0'
    implementation 'androidx.room:room-runtime:2.0.0'

    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.1'
    testImplementation 'junit:junit:4.12'

    annotationProcessor 'androidx.lifecycle:lifecycle-compiler:2.0.0'
    annotationProcessor 'androidx.room:room-compiler:2.0.0'
```

androidx.appcompat:appcompat:1.0.2 与 com.android.support:appcompat-v7:28.0.0 不能同时存在
使用 androidx.appcompat.app.AppCompatActivity 替代 android.support.v7.app.AppCompatActivity


## livedata, ViewModel 的使用


MutableLiveData

更新数据
setValue(T)
postValue(T)

> 必须要从主线程调用setValue(T) 方法来更新LiveData 对象. 如果代码在工作线程中执行, 你可以使用postValue(T) 方法来更新LiveData对象


LifecycleObserver

@OnLifecycleEvent(Lifecycle.Event.ON_RESUME)


ViewModelProviders.of().get();


在继承自 androidx.appcompat.app.AppCompatActivity 可以调用 getLifecycle().addObserver() 关联自定义的 LifecycleObserver


## LiveData配合Room使用


## Chronometer 计时器
```
    <Chronometer
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/chronometer"/>
```
```
    Chronometer chronometer = findViewById(R.id.chronometer);
    chronometer.start();
```

## 参考资料

* https://github.com/googlecodelabs/android-lifecycles

## todo

https://www.jianshu.com/p/87aa6464412b


https://blog.csdn.net/a990924291/article/details/82353679










