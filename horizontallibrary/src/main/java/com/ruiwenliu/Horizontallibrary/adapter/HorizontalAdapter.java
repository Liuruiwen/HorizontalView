package com.ruiwenliu.Horizontallibrary.adapter;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.ruiwenliu.Horizontallibrary.R;
import com.ruiwenliu.Horizontallibrary.inter.ItemValue;
import com.ruiwenliu.Horizontallibrary.inter.OnEditAttribute;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by ruiwen
 * Data:2018/8/20 0020
 * Email:1054750389@qq.com
 * Desc:
 */

public class HorizontalAdapter extends BaseRecyclerviewAdapter<ItemValue, RecylcerViewHolder> {

    private OnEditAttribute attribute;
    private LinearLayout.LayoutParams viewParams;//设置view的宽高；
    private LinearLayout.LayoutParams itemParams;//设置item的宽高；

    public HorizontalAdapter(OnEditAttribute attribute) {
        super(R.layout.item_horizontaly);
        this.attribute = attribute;
    }

    @Override
    protected void convert(RecylcerViewHolder helper, ItemValue item, int position) {
        ImageView ivLine = helper.getView(R.id.view_line);
        LinearLayout layout = helper.getView(R.id.lay_item);
        TextView tvContext = helper.getView(R.id.tv_name);
        setAttribute(layout, tvContext, ivLine, position);
        tvContext.setText(item.getItemValue());
    }


    /**
     * 设置view与item属性
     */
    private void setAttribute(LinearLayout layout, TextView tvContext, ImageView ivLine, int postion) {
        if (attribute != null) {
            setViewAttribute(layout, postion);
            setItemAttribute(tvContext, postion);
            setBottomAttribute(ivLine, postion);
        } else {
            ivLine.setVisibility(getSelectPostion() == postion ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 设置view的相关属性
     *
     * @param layout
     * @param position
     */
    private void setViewAttribute(LinearLayout layout, int position) {
        if (viewParams == null) {
            viewParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (attribute.isAdjustModel()) {
                viewParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                viewParams.height = AutoUtils.getPercentWidthSize(attribute.getVewHeight() > 0 ? attribute.getVewHeight() : 100);
            } else {
                viewParams.setMargins(0, 0, 0, 0);
                viewParams.width = attribute.getVewWidth() > 0 ? AutoUtils.getPercentWidthSize(attribute.getVewWidth()) : ViewGroup.LayoutParams.WRAP_CONTENT;
                viewParams.height = AutoUtils.getPercentWidthSize(attribute.getVewHeight() > 0 ? attribute.getVewHeight() : 100);
            }

        }
        layout.setLayoutParams(viewParams);
        switch (attribute.getViewType()) {
            case 0:

                break;
            case 1://设置选中的背景颜色
                layout.setBackgroundColor(ContextCompat.getColor(mContext, position == getSelectPostion() ? attribute.getSelectBgColor() == 0 ? R.color.colorRed : attribute.getSelectBgColor() : attribute.getNotSelectBgColor() == 0 ? R.color.textMain : attribute.getNotSelectBgColor()));
                break;
            case 2://设置选中的背景图片
                layout.setBackgroundResource(position == getSelectPostion() ? attribute.getSelectBgRes() : attribute.getNotSelectBgRes());
                break;
        }
    }


    /**
     * 设置Item相关属性
     *
     * @param tvContext
     * @param position
     */
    public void setItemAttribute(TextView tvContext, int position) {
        tvContext.setTextSize(AutoUtils.getPercentWidthSize(attribute.getTextSize() > 0 ? attribute.getTextSize() : 28));
        tvContext.setHeight(AutoUtils.getPercentWidthSize(attribute.getItemHeight() > 0 ? attribute.getItemHeight() : 30));
        tvContext.setTextColor(ContextCompat.getColor(mContext, getSelectPostion() == position ? attribute.getSelectTextColor() != 0 ? attribute.getSelectTextColor() : R.color.colorRed : attribute.getNotSelectTextColor() != 0 ? attribute.getNotSelectTextColor() : R.color.textMain));
    }

    /**
     * 设置底部下划线相关属性
     *
     * @param ivLine
     * @param position
     */
    public void setBottomAttribute(ImageView ivLine, int position) {
        if (itemParams == null) {
            itemParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            itemParams.width = attribute.getBottomWidth() > 0 ? AutoUtils.getPercentWidthSize(attribute.getBottomWidth()) : ViewGroup.LayoutParams.MATCH_PARENT;
            itemParams.height = AutoUtils.getPercentWidthSize(attribute.getBottomHeight() > 0 ? attribute.getBottomHeight() : 2);
        }
        ivLine.setLayoutParams(itemParams);
        ivLine.setVisibility(getSelectPostion() == position && attribute.isShowLine() ? View.VISIBLE : View.INVISIBLE);
        switch (attribute.getBottomViewType()) {
            case 0:

                break;
            case 1:
                ivLine.setBackgroundColor(ContextCompat.getColor(mContext, attribute.getBottomBackgoundColor() != 0 ? attribute.getBottomBackgoundColor() : R.color.colorRed));
                break;
            case 2:
                ivLine.setBackgroundResource(attribute.getBottomDrawable() != 0 ? attribute.getBottomDrawable() : 0);
                break;
        }
    }

}
