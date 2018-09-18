package com.ruiwenliu.Horizontallibrary.inter;

import android.view.View;

import com.ruiwenliu.Horizontallibrary.adapter.BaseRecyclerviewAdapter;


/**
 * Created by ruiwen
 * Data:2018/9/14 0014
 * Email:1054750389@qq.com
 * Desc:
 */

public interface OnItemClickListener {
   void onItemClick(BaseRecyclerviewAdapter adapter, View view, int position);
}
