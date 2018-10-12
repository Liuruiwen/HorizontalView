package com.ruiwenliu.HorizontalView.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.ruiwenliu.HorizontalView.R;
import com.ruiwenliu.HorizontalView.bean.HorizontalBean;
import com.ruiwenliu.Horizontallibrary.HorizontalScrollview;
import com.ruiwenliu.Horizontallibrary.adapter.BaseRecyclerviewAdapter;
import com.ruiwenliu.Horizontallibrary.adapter.RecylcerViewHolder;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HorizontalListActivity extends AutoLayoutActivity {

    @BindView(R.id.horizontal_scrollview)
    HorizontalScrollview horizontalScrollview;

    public static Intent getIntent(Context context) {
        return new Intent(context, HorizontalListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_list);
        ButterKnife.bind(this);
        horizontalScrollview.setItemSpace(5);//设置Item的间距
        horizontalScrollview.setCustomAdapter(new BaseRecyclerviewAdapter(R.layout.item_horizontal_viewly,getBean()) {

            @Override
            protected void convert(RecylcerViewHolder helper, Object item, int position) {
                helper.setText(R.id.tv_price, (String) item);
            }
        });
    }

    public List<String> getBean() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(String.format("%1$s%2$.2f","￥",888.2+i));
        }
        return list;
    }
}
