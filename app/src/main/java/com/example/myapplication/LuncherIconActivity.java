package com.example.myapplication;

import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LuncherIconActivity extends AppCompatActivity implements View.OnClickListener {

    private PackageManager mPackageManager;

    private ComponentName componentNameDefault;
    private ComponentName componentName1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher_icon);

        mPackageManager = getPackageManager();

        componentNameDefault = new ComponentName(getBaseContext(), "com.example.myapplication.MainActivity");
        componentName1 = new ComponentName(getBaseContext(), "com.example.myapplication.MainActivity1");

        findViewById(R.id.btn_default).setOnClickListener(this);
        findViewById(R.id.btn_spare).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_default:
                disableComponent(componentName1);
                enableComponent(componentNameDefault);
                break;
            case R.id.btn_spare:
                disableComponent(componentNameDefault);
                enableComponent(componentName1);
                break;
                default:
        }
    }

    /**
     * 启动组件
     *
     * @param componentName 组件名
     */
    private void enableComponent(ComponentName componentName) {
        //此方法用以启用和禁用组件，会覆盖Androidmanifest文件下定义的属性
        mPackageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
    }

    /**
     * 禁用组件
     *
     * @param componentName 组件名
     */
    private void disableComponent(ComponentName componentName) {
        mPackageManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

}
