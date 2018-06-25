package com.example.zhongxiong.com.wechatdemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by 牧羊人 on 2018/6/25.
 */

public class Toastutil {
    private Context context;

    public Toastutil(Context context, String s) {
        Toast.makeText(context, s, Toast.LENGTH_SHORT).show();
    }
}
