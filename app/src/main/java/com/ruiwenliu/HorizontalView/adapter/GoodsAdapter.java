package com.ruiwenliu.HorizontalView.adapter;


import com.ruiwenliu.HorizontalView.R;
import com.ruiwenliu.Horizontallibrary.adapter.BaseRecyclerviewAdapter;
import com.ruiwenliu.Horizontallibrary.adapter.RecylcerViewHolder;

/**
 * Created by ruiwen
 * Data:2018/8/16 0016
 * Email:1054750389@qq.com
 * Desc:
 */

public class GoodsAdapter extends BaseRecyclerviewAdapter<String, RecylcerViewHolder> {
    public GoodsAdapter() {
        super(R.layout.item_goodsly);
    }

    @Override
    protected void convert(RecylcerViewHolder helper, String item, int position) {
        helper.setText(R.id.tv_context, item);
    }
}
