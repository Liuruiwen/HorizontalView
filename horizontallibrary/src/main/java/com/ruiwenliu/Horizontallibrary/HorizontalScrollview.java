package com.ruiwenliu.Horizontallibrary;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.ruiwenliu.Horizontallibrary.adapter.BaseRecyclerviewAdapter;
import com.ruiwenliu.Horizontallibrary.adapter.HorizontalAdapter;
import com.ruiwenliu.Horizontallibrary.inter.ItemValue;
import com.ruiwenliu.Horizontallibrary.inter.OnEditAttributeLstener;
import com.ruiwenliu.Horizontallibrary.inter.OnItemClickListener;
import com.ruiwenliu.Horizontallibrary.weight.GallerySnapHelper;
import com.ruiwenliu.Horizontallibrary.weight.SpaceItemDecoration;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.List;

/**
 * Created by ruiwen
 * Data:2018/9/14 0014
 * Email:1054750389@qq.com
 * Desc:
 */

public class HorizontalScrollview<D, T extends BaseRecyclerviewAdapter> extends RecyclerView {
    private Context mContext;
    private T mAdapter;
    private int itemSpace;//item间距
    private boolean isAdjust;
    private OnEditAttributeLstener attributeLstener;

    public HorizontalScrollview(Context context) {
        super(context);
        this.mContext = context;
    }

    public HorizontalScrollview(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
    }


    @Override
    protected void onDetachedFromWindow() {
        attributeLstener=null;
        super.onDetachedFromWindow();
    }

    /**
     * 设置自定义菜单栏是否自适应
     */
    public void setCustomAdjustMode(boolean isAdjust) {
        this.isAdjust = isAdjust;
    }

    public void setItemSpace(int space){
        this.itemSpace=space;
    }

    /**
     * 设置自定义Adapter数据
     *
     * @param adapter
     */
    public HorizontalScrollview setCustomAdapter(T adapter) {
        if (adapter != null) {
            this.mAdapter = adapter;
            this.setLayoutManager(isAdjust ? new GridLayoutManager(mContext, mAdapter.getItemCount()) :new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            this.setAdapter(mAdapter);
            if (!isAdjust) {
                this.addItemDecoration(new SpaceItemDecoration(itemSpace == 0 ? AutoUtils.getPercentWidthSize(10) : itemSpace, mAdapter.getData().size()));
                GallerySnapHelper snapHelper = new GallerySnapHelper();
                snapHelper.attachToRecyclerView(this);
            }

        }
        return this;
    }


    /**
     * @param list
     * @param lstener
     * @return
     */
    public HorizontalScrollview setAdapter(List<ItemValue> list, OnEditAttributeLstener lstener) {
        if (list != null) {
            this.attributeLstener = lstener;
            this.mAdapter = (T) new HorizontalAdapter(attributeLstener);
            isAdjust = attributeLstener != null ? attributeLstener.isAdjustModel() : false;
            this.setLayoutManager(isAdjust ? new GridLayoutManager(mContext, list.size()) : new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
            this.setAdapter(mAdapter);
            this.mAdapter.setNewData(list);
            if (!isAdjust) {
                this.addItemDecoration(new SpaceItemDecoration(itemSpace == 0 ?AutoUtils.getPercentWidthSize(10) : itemSpace, mAdapter.getData().size()));
                GallerySnapHelper snapHelper = new GallerySnapHelper();
                snapHelper.attachToRecyclerView(this);
            }
        }
        return this;
    }


    /**
     * 重置列表数据
     */
    public void setNewData(List<D> list) {
        this.setLayoutManager(isAdjust ? new GridLayoutManager(mContext, list.size()) : new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        mAdapter.setNewData(list);
        mAdapter.setSelect(0);
    }


    /**
     * 设置Item点击事件
     *
     * @param itemClickListerter
     */
    public void setOnItemClickListerter(OnItemClickListener itemClickListerter) {
        if (mAdapter != null) {
            mAdapter.setOnItemClickListener(itemClickListerter);
        }
    }


    /**
     * 设置viewpager的滚动方位
     *
     * @param position
     */
    public void setScrollPosition(int position) {
        if (mAdapter != null) {
            this.scrollToPosition(position);
            mAdapter.setSelect(position);
        }
    }

}
