package com.major.app.bind;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.SparseIntArray;

import com.major.app.adapter.CommonAdapter;
import com.major.app.adapter.MultiTypeAdapter;

import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app
 * ProjectName: dagger2
 * Date: 2019/3/18 11:47
 */
public class RecyclerBinding {


    @BindingAdapter("app:data")
    public static void setRecyclerInfo(RecyclerView recyclerView , List datas){
        CommonAdapter mAdapter = (CommonAdapter) recyclerView.getAdapter();
        Log.i("tag_xx", "setRecyclerInfo " + mAdapter);

        mAdapter.setData(datas);
    }

    @BindingAdapter({"app:data", "app:layoutMapping"})
    public static void setRecyclerInfo(RecyclerView recyclerView , List data, SparseIntArray mapping){
        MultiTypeAdapter mAdapter = (MultiTypeAdapter) recyclerView.getAdapter();
        mAdapter.setData(data, mapping);
    }
}
