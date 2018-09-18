package com.ruiwenliu.HorizontalView;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by ruiwen
 * Data:2018/9/14 0014
 * Email:1054750389@qq.com
 * Desc:
 */

public class MainAppliction extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        //autoLayout初始化
        AutoLayoutConifg.getInstance().useDeviceSize().init(this);
    }
}
