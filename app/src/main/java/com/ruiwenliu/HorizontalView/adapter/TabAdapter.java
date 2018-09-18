package com.ruiwenliu.HorizontalView.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.ViewGroup;


import com.ruiwenliu.HorizontalView.view.BaseFragment;

import java.util.List;

/**
 * Created by ruiwen
 * Data:2018/8/16 0016
 * Email:1054750389@qq.com
 * Desc:
 */

public class TabAdapter extends FragmentPagerAdapter {
    private int position;

    private List<BaseFragment> list;

    public TabAdapter(FragmentManager fm, List<BaseFragment> list) {
        super(fm);
        this.list = list;
    }

    public Fragment getCurrentFragment() {
        return list.get(position);
    }

    @Override
    public Fragment getItem(int i) {
        return list.get(i);
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        this.position = position;
    }


    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    /**
     * 刷新新数据
     */
    public void refreshData(List<BaseFragment> listFragment){
        list.clear();
        list=listFragment;
        notifyDataSetChanged();
        }
}
