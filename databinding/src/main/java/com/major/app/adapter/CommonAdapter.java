package com.major.app.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc: TODO
 * <p>
 * Author: meijie
 * PackageName: com.major.app
 * ProjectName: dagger2
 * Date: 2019/3/18 10:58
 */
public class CommonAdapter<T> extends RecyclerView.Adapter<CommonAdapter.CustomViewHolder> {

    List<T> mData = new ArrayList<>();

    private int mLayoutId = -1;
    private int mVariableId = -1;

    public CommonAdapter() {
    }

    /**
     * 通用Adapter的构造函数
     *
     * @param layoutId   item的布局文件ID
     * @param variableId 布局文件中data中的变量ID，eg. 变量名为viewModel,则这里传值为BR.viewModel
     */
    public CommonAdapter(int layoutId, int variableId) {
        mLayoutId = layoutId;
        mVariableId = variableId;
    }

    public void setData(List data) {
        if (data != null) {
            this.mData = data;
            notifyDataSetChanged();
        }
    }

    public void addData(List<T> data) {
        if (data != null) {
            int ps = mData.size();
            mData.addAll(data);
            notifyItemRangeInserted(ps, data.size());
        }
    }

    /**
     * 设置布局文件ID
     *
     * @param layoutId Item布局文件ID
     */
    public void setLayoutId(int layoutId) {
        mLayoutId = layoutId;
    }

    /**
     * 设置布局文件中Data部分变量ID，eg.  变量名为viewModel,则这里传值为BR.viewModel
     *
     * @param variableId Data部分变量ID
     */
    public void setVariableId(int variableId) {
        mVariableId = variableId;
    }

    @Override
    public CommonAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mLayoutId != -1 && mVariableId != -1) {
            ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), mLayoutId, parent, false);
            return new CustomViewHolder(binding);
        } else {
            throw new IllegalArgumentException("No layoutId & variableId !!!");
        }
    }

    @Override
    public void onBindViewHolder(CommonAdapter.CustomViewHolder holder, int position) {
        T itemInfo = mData.get(position);
        holder.mBinding.setVariable(mVariableId, itemInfo);
        Log.i("tag_xx", "onBindViewHolder " + itemInfo);
        holder.mBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class CustomViewHolder extends RecyclerView.ViewHolder {
        ViewDataBinding mBinding;

        public CustomViewHolder(@NonNull ViewDataBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }
    }
}
