package com.bwie.test.fragmentguanli;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fr;
    private TextView te1;
    private TextView te2;
    private FragmentManager supportFragmentManager;
    private Fragment01 fragment01;
    private Fragment02 fragment02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        te1.setTextColor(Color.RED);
        te2.setTextColor(Color.BLACK);
        supportFragmentManager = getSupportFragmentManager();
        // 添加fragment0到容器上
        // 开启一个事务
        FragmentTransaction beginTransaction = supportFragmentManager
                .beginTransaction();
        //创建fragment对象
        final Fragment01 fr01=new Fragment01();
        final Fragment02 fr02=new Fragment02();
        //把fragment添加到事务中
        beginTransaction.add(R.id.fr, fr01, "fr01");
        beginTransaction.add(R.id.fr, fr02, "fr02");
        //显示或隐藏Fragment
        beginTransaction.show(fr01);
        beginTransaction.hide(fr02);
        beginTransaction.commit();
        //点击按钮显示与之对应的fragment
        te1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击按钮使之变色
                te1.setTextColor(Color.RED);
                te2.setTextColor(Color.BLACK);
                FragmentTransaction beginTransaction = supportFragmentManager
                        .beginTransaction();
                beginTransaction.show(fr01);
                beginTransaction.hide(fr02);
                beginTransaction.commit();
            }
        });
        te2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                te2.setTextColor(Color.RED);
                te1.setTextColor(Color.BLACK);
                FragmentTransaction beginTransaction = supportFragmentManager
                        .beginTransaction();
                beginTransaction.show(fr02);
                beginTransaction.hide(fr01);
                beginTransaction.commit();
            }
        });
    }
    //初始化控件
    private void initview() {
        fr = (FrameLayout) findViewById(R.id.fr);
        te1 = (TextView) findViewById(R.id.te1);
        te2 = (TextView) findViewById(R.id.te2);
    }
}
