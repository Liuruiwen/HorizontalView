package com.ruiwenliu.HorizontalView.view;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;


import com.ruiwenliu.HorizontalView.adapter.GoodsAdapter;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruiwen
 * Data:2018/8/16 0016
 * Email:1054750389@qq.com
 * Desc:
 */

public class GoodsFragment extends BaseFragment {
    private GoodsAdapter mAdapter = null;
    private int type;


    public static GoodsFragment getInstance(int type) {
        Bundle bundl = new Bundle();
        bundl.putInt("type", type);
        GoodsFragment goodsFragment = new GoodsFragment();
        goodsFragment.setArguments(bundl);
        return goodsFragment;
    }


    @Override
    protected void initView() {
        if (getArguments() != null) {
            type = getArguments().getInt("type");
        }
        mAdapter = new GoodsAdapter();
        goodsRv.setLayoutManager(new LinearLayoutManager(_mActivity));
        goodsRv.setAdapter(mAdapter);
        mAdapter.setNewData(getListData(type));

    }

    @Override
    protected void setData() {

    }



    private List<String> getListData(int type) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("买商品，卖商品，买卖商品,绝对的好商品，快来买咯" + type);
        }

        return list;
    }

}
