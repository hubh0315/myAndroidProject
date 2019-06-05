package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.myapplication.Java8.Java8TestActivity;
import com.example.myapplication.picinpic.PicMainActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
//                WindowManager.LayoutParams. FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
        decorView.setSystemUiVisibility(option);

        getWindow().setStatusBarColor(Color.TRANSPARENT);

        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        findViewById(R.id.button_pic).setOnClickListener(this);
        findViewById(R.id.button_text).setOnClickListener(this);
        findViewById(R.id.button_java8).setOnClickListener(this);
        findViewById(R.id.button_notification).setOnClickListener(this);
        findViewById(R.id.button_sys_dialog).setOnClickListener(this);
        findViewById(R.id.button_scroll).setOnClickListener(this);
        findViewById(R.id.button_xml).setOnClickListener(this);
        findViewById(R.id.button_luncher_icon).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_pic:
                start(PicMainActivity.class);
                break;
            case R.id.button_text:
                start(AutoSizeActivity.class);
                break;
            case R.id.button_java8:
                start(Java8TestActivity.class);
                break;
            case R.id.button_notification:
                start(NotificationActivity.class);
                break;
            case R.id.button_sys_dialog:
                start(DialogActivity.class);
                break;
            case R.id.button_scroll:
                start(ScrollActivity.class);
                break;
            case R.id.button_xml:
                start(XmlActivity.class);
                break;
            case R.id.button_luncher_icon:
                start(LuncherIconActivity.class);
                break;
            default:
        }
    }

    private void start(Class<?> aClass) {
        Intent intent = new Intent(this, aClass);
        startActivity(intent);
    }
}
