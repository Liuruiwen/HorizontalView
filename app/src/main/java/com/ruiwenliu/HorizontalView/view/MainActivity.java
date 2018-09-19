package com.ruiwenliu.HorizontalView.view;

import android.os.Bundle;
import android.view.View;

import com.ruiwenliu.HorizontalView.R;
import com.ruiwenliu.HorizontalView.bean.HorizontalBean;
import com.ruiwenliu.Horizontallibrary.HorizontalScrollview;
import com.ruiwenliu.Horizontallibrary.adapter.BaseRecyclerviewAdapter;
import com.ruiwenliu.Horizontallibrary.inter.OnEditAttributeLstener;
import com.ruiwenliu.Horizontallibrary.inter.OnItemClickListener;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AutoLayoutActivity implements OnItemClickListener {


    @BindView(R.id.horizontal_refresh)
    HorizontalScrollview horizontalRefresh;
    @BindView(R.id.horizontal_line)
    HorizontalScrollview horizontalLine;
    @BindView(R.id.horizontal_bg)
    HorizontalScrollview horizontalBg;
    @BindView(R.id.horizontal_scroll)
    HorizontalScrollview horizontalScroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        horizontalRefresh.setAdapter(getBean(), new OnEditAttributeLstener() {
            @Override
            public boolean isAdjustModel() {
                return true;
            }
        });
        horizontalLine.setAdapter(getNewBean(), new OnEditAttributeLstener() {
            @Override
            public boolean isAdjustModel() {
                return true;
            }

            @Override
            public int getBottomWidth() {
                return 100;
            }
        });

        horizontalBg.setBackgroundResource(R.drawable.shape_border_red);
        horizontalBg.setAdapter(getNewBean(), new OnEditAttributeLstener() {
            /**
             *
             * @return0、不设置背景、1设置背景颜色、2、设置背景图片
             */
            @Override
            public int getViewType() {
                return 2;
            }

            @Override
            public int getVewHeight() {
                return 80;//设置菜单栏的高度
            }

            @Override
            public boolean isAdjustModel() {
                return true;//是否自适应
            }

            @Override
            public int getSelectBgRes() {
                return R.drawable.shape_bg_red;//设置选中item的背景
            }

            @Override
            public int getNotSelectBgRes() {
                return 0;//设置未选中item的背景
            }

            @Override
            public int getSelectTextColor() {
                return R.color.colorWrite;//设置选中item 字体颜色
            }

            @Override
            public int getNotSelectTextColor() {
                return R.color.textMain;//设置未选中item 字体颜色
            }

            @Override
            public boolean isShowLine() {
                return false;//隐藏下划线
            }
        });

        horizontalScroll.setItemSpace(20);
        horizontalScroll.setAdapter(getHorizontalBean(), new OnEditAttributeLstener() {
            @Override
            public boolean isAdjustModel() {
                return false;//true自适应显示、false可以滚动
            }
        });

        horizontalRefresh.setOnItemClickListerter(this);
        horizontalLine.setOnItemClickListerter(this);
        horizontalBg.setOnItemClickListerter(this);
        horizontalScroll.setOnItemClickListerter(this);
    }


    public List<HorizontalBean> getBean() {
        List<HorizontalBean> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HorizontalBean bean = new HorizontalBean();
            bean.title = "小瑞文" + i;
            list.add(bean);
        }
        return list;
    }

    public List<HorizontalBean> getNewBean() {
        List<HorizontalBean> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HorizontalBean bean = new HorizontalBean();
            bean.title = "小瑞文" + i;
            list.add(bean);
        }

        return list;
    }

    public List<HorizontalBean> getHorizontalBean() {
        List<HorizontalBean> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            HorizontalBean bean = new HorizontalBean();
            bean.title = "小瑞文" + i;
            list.add(bean);
        }
        return list;
    }


    @OnClick({R.id.btn_refresh, R.id.tv_viewpager, R.id.tv_horizontal_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_refresh:
                horizontalRefresh.setNewData(getNewBean());
                break;
            case R.id.tv_viewpager:
                startActivity(ViewPagerActivity.getIntent(this));
                break;
            case R.id.tv_horizontal_list:
                startActivity(HorizontalListActivity.getIntent(this));
                break;
        }
    }

    @Override
    public void onItemClick(BaseRecyclerviewAdapter adapter, View view, int position) {

    }
}
