package com.gxg.customizeviewtest.bean;

import android.support.annotation.NonNull;

/**
 * 作者：Administrator on 2018/6/26 14:06
 * 邮箱：android_gaoxuge@163.com
 */
public class PieBean {
    private String name;//名字
    private float value;//数值
    private float percentage;//百分比
    private int color;//颜色
    private float angle;//角度

    public PieBean(@NonNull String name,@NonNull int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
