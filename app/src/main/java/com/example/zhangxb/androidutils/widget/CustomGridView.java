package com.example.zhangxb.androidutils.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @author zhangxb
 * @description 自定义GridView
 */
public class CustomGridView extends GridView {

    public CustomGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    public CustomGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    public CustomGridView(Context context) {
        super(context);
        this.setSelector(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
