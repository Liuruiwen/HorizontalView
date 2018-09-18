package com.ruiwenliu.HorizontalView.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.ruiwenliu.HorizontalView.R;
import com.ruiwenliu.HorizontalView.adapter.TabAdapter;
import com.ruiwenliu.HorizontalView.bean.HorizontalBean;
import com.ruiwenliu.HorizontalView.bean.ItemBean;
import com.ruiwenliu.Horizontallibrary.HorizontalScrollview;
import com.ruiwenliu.Horizontallibrary.adapter.BaseRecyclerviewAdapter;
import com.ruiwenliu.Horizontallibrary.adapter.RecylcerViewHolder;
import com.ruiwenliu.Horizontallibrary.inter.OnItemClickListener;
import com.zhy.autolayout.AutoLayoutActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewPagerActivity extends AutoLayoutActivity {

    @BindView(R.id.horizontal_scrollview)
    HorizontalScrollview horizontalScrollview;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    public static Intent getIntent(Context context){
        return new Intent(context,ViewPagerActivity.class);
    }

    private TabAdapter mAdapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pagerly);
        ButterKnife.bind(this);
        horizontalScrollview.setCustomAdapter(new BaseRecyclerviewAdapter<ItemBean,RecylcerViewHolder>(R.layout.item_viewly,getNewBean()) {
            @Override
            protected void convert(RecylcerViewHolder helper, ItemBean item, int position) {
                TextView tvName=helper.getView(R.id.tv_title);
                TextView tvTime=helper.getView(R.id.tv_time);
                tvName.setText( item.menuName);
                tvTime.setText(item.menuTime);
                tvName.setTextColor(ContextCompat.getColor(mContext,position==getSelectPostion()? R.color.colorRed:R.color.textMain));
                tvTime.setTextColor(ContextCompat.getColor(mContext,position==getSelectPostion()? R.color.colorRed:R.color.textMain));
                helper.setVisible(R.id.view_line,position==getSelectPostion()?true:false);

            }
        });

        horizontalScrollview.setOnItemClickListerter(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseRecyclerviewAdapter adapter, View view, int position) {
                viewpager.setCurrentItem(position,false);
            }
        });
        mAdapter = new TabAdapter(getSupportFragmentManager(), getListFragment());
        viewpager.setAdapter(mAdapter);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                horizontalScrollview.setScrollPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    public List<ItemBean> getNewBean() {
        List<ItemBean> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ItemBean bean = new ItemBean();
            bean.menuName = "小瑞文" + i;
            bean.menuTime="2018/10/"+i;
            list.add(bean);
        }
        return list;
    }
    private List<BaseFragment> getListFragment() {
        List<BaseFragment> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(GoodsFragment.getInstance(i));
        }
        return list;
    }

    @OnClick({R.id.tv_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_back:
                finish();
                break;

        }
    }

}
