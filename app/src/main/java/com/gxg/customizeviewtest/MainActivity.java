package com.gxg.customizeviewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.gxg.customizeviewtest.activity.FirstActivity;
import com.gxg.customizeviewtest.activity.SecondActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_first)
    TextView tvFirst;
    @Bind(R.id.tv_second)
    TextView tvSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_first, R.id.tv_second})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_first:
                startActivity(new Intent(MainActivity.this, FirstActivity.class));
                break;
            case R.id.tv_second:
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
                break;
        }
    }
}
