package com.example.myapplication;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.myapplication.Java8.Java8TestActivity;
import com.example.myapplication.picinpic.PicMainActivity;

public class DialogActivity extends AppCompatActivity implements View.OnClickListener {

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

        setContentView(R.layout.activity_dialog);

        initView();

        BaseReceiver mRefreshBrdcase = new BaseReceiver();
        IntentFilter filter1 = new IntentFilter();
        filter1.addAction("com.mmar.sdk");
        registerReceiver(mRefreshBrdcase, filter1);


//        if (Build.VERSION.SDK_INT >= 23) {
//            if (! Settings.canDrawOverlays(this)) {
//                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
//                        Uri.parse("package:" + getPackageName()));
//                startActivityForResult(intent,10);
//            }
//        }
    }

    private void initView() {
        findViewById(R.id.button_jump).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_jump:
                start(SendBroadcastActivity.class);
                break;
            default:
        }
    }

    private void start(Class<?> aClass) {
        Intent intent = new Intent(this, aClass);
        startActivity(intent);
    }

    private class BaseReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals("com.mmar.sdk")) {

                AlertDialog.Builder normalDialog = new AlertDialog.Builder(DialogActivity.this);
                //设置title
                normalDialog.setTitle("提示");
                //设置icon
//                    normalDialog.setIcon(R.mipmap.ic_launcher_round);
                //设置内容
                normalDialog.setMessage("1111");
                //设置按钮
                normalDialog.setPositiveButton("确认"
                        , new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
//                                Toast.makeText(DialogActivity.this, "", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                            }
                        });
                //创建并显示
                AlertDialog dialog = normalDialog.create();

                //只有这样才能弹框
                if (Build.VERSION.SDK_INT>=26) {//8.0新特性
                    dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY);
                }else{
                    dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
                }

//                dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
                dialog.show();
            }
        }
    }

}
