package com.ruiwenliu.HorizontalView.bean;


import com.ruiwenliu.Horizontallibrary.inter.ItemValue;

/**
 * Created by ruiwen
 * Data:2018/9/17 0017
 * Email:1054750389@qq.com
 * Desc:
 */

public class HorizontalBean implements ItemValue {

    public String title;
    @Override
    public String getItemValue() {
        return title;
    }
}
