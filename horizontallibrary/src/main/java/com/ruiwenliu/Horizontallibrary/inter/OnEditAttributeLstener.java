package com.ruiwenliu.Horizontallibrary.inter;

/**
 * Created by ruiwen
 * Data:2018/9/17 0017
 * Email:1054750389@qq.com
 * Desc:
 */

public abstract  class OnEditAttributeLstener implements OnEditAttribute{

    @Override
    public boolean isAdjustModel() {
        return false;
    }

    @Override
    public int getVewHeight() {
        return 0;
    }

    @Override
    public int getVewWidth() {
        return 0;
    }

    @Override
    public int getViewType() {
        return 0;
    }

    @Override
    public int getSelectBgColor() {
        return 0;
    }

    @Override
    public int getNotSelectBgColor() {
        return 0;
    }

    @Override
    public int getSelectBgRes() {
        return 0;
    }

    @Override
    public int getNotSelectBgRes() {
        return 0;
    }

    @Override
    public int getSelectTextColor() {
        return 0;
    }

    @Override
    public int getNotSelectTextColor() {
        return 0;
    }

    @Override
    public int getTextSize() {
        return 0;
    }

    @Override
    public int getItemHeight() {
        return 0;
    }


    @Override
    public int getBottomViewType() {
        return 0;
    }

    @Override
    public boolean isShowLine() {
        return true;
    }

    @Override
    public int getBottomWidth() {
        return 0;
    }

    @Override
    public int getBottomHeight() {
        return 0;
    }

    @Override
    public int getBottomBackgoundColor() {
        return 0;
    }

    @Override
    public int getBottomDrawable() {
        return 0;
    }
}
