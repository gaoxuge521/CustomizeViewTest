package com.gxg.customizeviewtest.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.gxg.customizeviewtest.bean.PieBean;

import java.util.ArrayList;

/**
 * 作者：Administrator on 2018/6/26 14:06
 * 邮箱：android_gaoxuge@163.com
 */
public class PieView extends View {
    // 颜色表(注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
    private int[] mColors = {0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
            0xFFE6B800, 0xFF7CFC00};
    //初始角度
    private float mStartAngle=0;
    //数据
    private ArrayList<PieBean> mData;
    //宽高
    private int mWidth,mHeight;
    //画笔
    private Paint mPaint = new Paint();

    public PieView(Context context) {
        this(context, null);
    }

    public PieView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
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
        mHeight = h;
        mWidth = w;
    }

    /**
     * 设置初始角度
     * @param mStartAngle 初始角度
     */
    public void setmStartAngle(float mStartAngle) {
        this.mStartAngle = mStartAngle;
        invalidate();
    }

    /**
     * 设置数据
     * @param mData
     */
    public void setmData(ArrayList<PieBean> mData) {
        this.mData = mData;
        initData(mData);
        invalidate();
    }

    private void initData(ArrayList<PieBean> mData) {
        if(null==mData || mData.size()==0){
            return;
        }
        float sumValue = 0;//所有数值之和

        //循环设置颜色
        for (int i = 0; i < mData.size(); i++) {
            PieBean pieBean = mData.get(i);
            sumValue += pieBean.getValue();
            int j  = i%mColors.length;
            pieBean.setColor(mColors[j]);
        }
        float sumAngle=0;//百分比
        for (int i = 0; i < mData.size(); i++) {
            PieBean pieBean = mData.get(i);
            //计算百分比
            float percentage = pieBean.getValue()/sumValue;
            //计算角度
            float angle = percentage * 360;
            //记录百分比和角度
            pieBean.setPercentage(percentage);
            pieBean.setAngle(angle);
            sumAngle += angle;
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(null==mData){
            return;
        }
        //当前起始角度
        float currentStartAngle = mStartAngle;
        //画布坐标移动到中心
        canvas.translate(mWidth/2,mHeight/2);
        //计算饼图半径
        float r = (float) ((Math.min(mWidth,mHeight))/2 * 0.8);
        //饼图绘制区域
        RectF rectF = new RectF(-r,-r,r,r);
        for (int i = 0; i < mData.size(); i++) {
            PieBean pieBean = mData.get(i);
            mPaint.setColor(pieBean.getColor());
            canvas.drawArc(rectF,currentStartAngle,pieBean.getAngle(),true,mPaint);
            currentStartAngle+=pieBean.getAngle();
        }

    }


}
