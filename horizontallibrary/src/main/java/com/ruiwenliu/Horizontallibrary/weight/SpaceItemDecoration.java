package com.ruiwenliu.Horizontallibrary.weight;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by ruiwen
 * Data:2018/9/14 0014
 * Email:1054750389@qq.com
 * Desc:间距
 */

public class SpaceItemDecoration extends RecyclerView.ItemDecoration {

    private static final int DEFAULT_COLUMN = Integer.MAX_VALUE;
    private int space;
    private int column;

    public SpaceItemDecoration(int space) {
        this(space, DEFAULT_COLUMN);
    }

    public SpaceItemDecoration(int space, int column) {
        this.space = AutoUtils.getPercentWidthSize(space) ;
        this.column = column;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.top = space;
        int pos = parent.getChildLayoutPosition(view);
        int total = parent.getChildCount();
        if (isFirstRow(pos)) {
            outRect.top = 0;
        }
        if (isLastRow(pos, total)) {
            outRect.bottom = 5;
        }
        if (column != DEFAULT_COLUMN) {
            float avg = (column - 1) * space * 1.0f / column;
            outRect.left = (int) (pos%column * (space - avg));
            outRect.right = (int) (avg - (pos%column * (space - avg)));
        }
    }

    boolean isFirstRow(int pos) {
        return pos < column;
    }

    boolean isLastRow(int pos, int total) {
        return total - pos <= column;
    }



}
