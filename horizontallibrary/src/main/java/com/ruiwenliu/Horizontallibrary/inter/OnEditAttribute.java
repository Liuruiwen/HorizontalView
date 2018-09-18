package com.ruiwenliu.Horizontallibrary.inter;

/**
 * Created by ruiwen
 * Data:2018/9/14 0014
 * Email:1054750389@qq.com
 * Desc:
 */

public interface OnEditAttribute {
    /**
     * 是否自适应
     * @return
     */
    boolean isAdjustModel();

    /*** ======设置View属性       ********/

    /**
     *获得View的属性类型
     * @return
     */
    int getViewType();

    /**
     * 改变view高度
     * @return
     */
    int getVewHeight();
    /**
     * 改变view高度
     * @return
     */
    int getVewWidth();

    /**
     * 获取选中的背景颜色
     * @return
     */
    int getSelectBgColor();
    /**
     * 获取未选中的背景颜色
     * @return
     */
    int getNotSelectBgColor();

    /**
     * 获取选中的背景颜色
     * @return
     */
    int getSelectBgRes();
    /**
     * 获取未选中的背景颜色
     * @return
     */
    int getNotSelectBgRes();


    /*** ======设置Item属性       ********/
    /**
     *获取选中的字体颜色
     * @return
     */
    int getSelectTextColor();

    /**
     *获取未选中的字体颜色
     * @return
     */
    int getNotSelectTextColor();

    /**
     * 获取字体大小
     * @return
     */
    int getTextSize();

    /**
     * 获取Item高度
     * @return
     */
    int getItemHeight();



    /*** ======设置bottom属性       ********/



    /**
     *获得底部下划线的属性类型
     * @return
     */
    int getBottomViewType();
    /**
     * 是否显示下划线
     * @return
     */
     boolean isShowLine();

    /**
     * 改变bottom下划线高度
     * @return
     */
    int getBottomHeight();
    /**
     * 改变bottom宽度
     * @return
     */
    int getBottomWidth();

    /**
     * 设置底部下划线背景颜色
     * @return
     */
    int getBottomBackgoundColor();
    /**
     * 设置底部图片
     * @return
     */
     int getBottomDrawable();
}
