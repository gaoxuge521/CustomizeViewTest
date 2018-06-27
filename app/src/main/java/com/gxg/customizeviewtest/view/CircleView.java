package com.gxg.customizeviewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：Administrator on 2018/6/26 15:20
 * 邮箱：android_gaoxuge@163.com
 */
public class CircleView extends View {
    private Paint mPaint ;
    private int mWidth,mHeight;

    public CircleView(Context context) {
        this(context,null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setColor(0xFF800000);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = MeasureSpec.getSize(widthMeasureSpec);
        mHeight = MeasureSpec.getSize(heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth = w;
        mHeight = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画布移动到中心
        canvas.translate(mWidth/2,mHeight/2);
        int circleRadio = Math.max(mWidth,mHeight)-5;
        canvas.drawCircle(0,0,circleRadio/2,mPaint);
        canvas.drawCircle(0,0,(circleRadio-30)/2,mPaint);
        for (int i = 0; i < 360; i++) {
            canvas.drawLine(0,circleRadio/2,0,(circleRadio-30)/2,mPaint);
            canvas.rotate(10);
        }

    }
}
