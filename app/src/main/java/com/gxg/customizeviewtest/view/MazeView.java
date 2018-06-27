package com.gxg.customizeviewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.socks.library.KLog;

/**
 * 作者：Administrator on 2018/6/26 14:50
 * 邮箱：android_gaoxuge@163.com
 */
public class MazeView extends View {
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    private float rectLength;//矩形长度
    public MazeView(Context context) {
        this(context,null);
    }

    /**
     * 设置矩形的宽度
     * @param rectLength
     */
    public void setRectLength(float rectLength) {
        this.rectLength = rectLength;
        invalidate();
    }

    public MazeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MazeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(0xFF800000);
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
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
        canvas.translate(mWidth/2,mHeight/2);
        if(rectLength>Math.max(mWidth,mHeight) || rectLength==0){
            rectLength = (float )(Math.max(mWidth,mHeight)/2);
        }
        float rect = rectLength;
        RectF rectF = new RectF(-rectLength,-rectLength,rectLength,rectLength);
        while (true){
            rect*=0.9;
            canvas.scale(0.9f,0.9f);
            canvas.drawRect(rectF,mPaint);
            if(rect<=10){
                break;
            }
        }
    }
}
