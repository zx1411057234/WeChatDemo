package com.example.zhongxiong.com.wechatdemo;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zhongxiong.com.wechatdemo.fragment.FragmentCollector;


public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {

    private RadioButton rb_1;
    private RadioButton rb_2;
    private RadioButton rb_3;
    private RadioButton rb_4;
    private RadioGroup rg_group;
    private FrameLayout fl_contnt;

    private FragmentCollector fragmentCollector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentShow(0);

    }

    private void initView() {
        rb_1 = (RadioButton) findViewById(R.id.rb_1);
        rb_2 = (RadioButton) findViewById(R.id.rb_2);
        rb_3 = (RadioButton) findViewById(R.id.rb_3);
        rb_4 = (RadioButton) findViewById(R.id.rb_4);
        rg_group = (RadioGroup) findViewById(R.id.rg_group);
        fl_contnt = (FrameLayout) findViewById(R.id.fl_contnt);

        rb_1.setOnCheckedChangeListener(this);
        rb_2.setOnCheckedChangeListener(this);
        rb_3.setOnCheckedChangeListener(this);
        rb_4.setOnCheckedChangeListener(this);

        rb_1.setOnClickListener(this);
        rb_2.setOnClickListener(this);
        rb_3.setOnClickListener(this);
        rb_4.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) buttonView.setTextColor(Color.GREEN);
        else buttonView.setTextColor(Color.GRAY);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_1:

                fragmentShow(0);

                break;
            case R.id.rb_2:
                fragmentShow(1);

                break;
            case R.id.rb_3:
                fragmentShow(2);

                break;
            case R.id.rb_4:

                fragmentShow(3);
                break;
        }
    }

    public void fragmentShow(int position) {
        fragmentCollector = fragmentCollector.getIntance(MainActivity.this, R.id.fl_contnt);
        fragmentCollector.getFragment(position);
        fragmentCollector.showFragment(position);
    }
}
