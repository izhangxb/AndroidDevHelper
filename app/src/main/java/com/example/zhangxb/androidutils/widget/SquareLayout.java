package com.example.zhangxb.androidutils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.example.zhangxb.androidutils.R;


/**
 * 方形layout，常用于gridView
 * Created by zhangxb on 15/12/4.
 */
public class SquareLayout extends RelativeLayout {

    private float aspectRatio = 1f;

    public SquareLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        applyConfig(context, attrs);
    }

    public SquareLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyConfig(context, attrs);
    }

    public SquareLayout(Context context) {
        super(context);
    }

    private void applyConfig(Context context, AttributeSet attrs) {
        if (attrs == null) {
            return;
        }
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SquareLayout);
        aspectRatio = a.getFloat(R.styleable.SquareLayout_aspectRatio, 1f);
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // For simple implementation, or internal size is always 0.
        // We depend on the container to specify the layout size of
        // our view. We can't really know what it is since we will be
        // adding and removing different arbitrary views and do not
        // want the layout to change as this happens.
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));

        // Children are just made to fill our space.
        int childWidthSize = getMeasuredWidth();
        int childHeightSize = getMeasuredHeight();
        //高度和宽度一样
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        heightMeasureSpec = MeasureSpec.makeMeasureSpec((int) (aspectRatio * childWidthSize), MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
