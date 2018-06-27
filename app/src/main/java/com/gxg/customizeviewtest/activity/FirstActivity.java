package com.gxg.customizeviewtest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gxg.customizeviewtest.R;
import com.gxg.customizeviewtest.bean.PieBean;
import com.gxg.customizeviewtest.view.MazeView;
import com.gxg.customizeviewtest.view.PieView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：Administrator on 2018/6/26 13:47
 * 邮箱：android_gaoxuge@163.com
 */
public class FirstActivity extends AppCompatActivity {
    @Bind(R.id.pieview)
    PieView pieview;
    @Bind(R.id.mazeview)
    MazeView mazeview;
    private ArrayList<PieBean> pieList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        ButterKnife.bind(this);
        pieList.clear();
        for (int i = 0; i < 8; i++) {
            pieList.add(new PieBean("hh",i+5));
        }
        pieview.setmData(pieList);
    }
}
