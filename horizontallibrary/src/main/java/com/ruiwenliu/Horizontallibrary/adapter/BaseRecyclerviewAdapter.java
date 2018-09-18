package com.ruiwenliu.Horizontallibrary.adapter;

import android.content.Context;
import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.ruiwenliu.Horizontallibrary.inter.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiwen
 * Data:2018/9/14 0014
 * Email:1054750389@qq.com
 * Desc:
 */

public abstract class BaseRecyclerviewAdapter<D, T extends RecylcerViewHolder> extends RecyclerView.Adapter<T> {

    protected Context mContext;
    protected int mLayoutResId;
    protected List<D> mData;
    private int postion;
    private OnItemClickListener mOnItemClick;

    public BaseRecyclerviewAdapter(int layoutResId, List<D> data) {
        this.mLayoutResId = layoutResId;
        this.mData = data;
    }

    public BaseRecyclerviewAdapter(int layoutResId) {
        this.mLayoutResId = layoutResId;
    }


    @Override
    public T onCreateViewHolder(ViewGroup parent, int viewType) {
        this.mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(mLayoutResId, parent, false);
        getItemView(view);
        T viewHolder = (T) new RecylcerViewHolder(view);
        bindViewClick(viewHolder);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(T holder, int position) {
        convert(holder, getItem(position), position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public List<D> getData() {
        return mData == null ? new ArrayList<D>() : mData;
    }

    /**
     * 更新数据
     *
     * @param data
     */
    public void setNewData(List<D> data) {
        this.mData = data == null ? new ArrayList<D>() : data;
        notifyDataSetChanged();
    }

    protected abstract void convert(T helper, D item, int position);

    public D getItem(@IntRange(from = 0) int position) {
        return position >= 0 && position < mData.size() ? mData.get(position) : null;
    }


    private void bindViewClick(final RecylcerViewHolder viewHolder) {
        if (viewHolder == null) {
            return;
        }
        final View view = viewHolder.itemView;
        if (view == null) {
            return;
        }

        if (mOnItemClick != null) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setSelect(viewHolder.getLayoutPosition());
                    mOnItemClick.onItemClick(BaseRecyclerviewAdapter.this, v, viewHolder.getLayoutPosition());

                }
            });
        }

    }

    public void setOnItemClickListener(OnItemClickListener onItemClick) {
        this.mOnItemClick = onItemClick;
    }


    public int getSelectPostion() {
        return postion;
    }


    public void setSelect(int postion) {
        this.postion = postion;
        notifyDataSetChanged();
    }

    public void getItemView(View view) {

    }


}
