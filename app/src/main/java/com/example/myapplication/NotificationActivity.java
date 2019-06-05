package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NotificationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        findViewById(R.id.button).setOnClickListener(this);

        notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                sendSimpleNotificationSecond();
                break;
            default:
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public void createChannelId(String channelId) {
        NotificationChannel channel = new NotificationChannel(channelId, "通知渠道2",
                NotificationManager.IMPORTANCE_DEFAULT);

        // 配置通知渠道的属性
        channel.setDescription("渠道的描述");
        // 设置通知出现时的闪灯（如果 android 设备支持的话）
        channel.enableLights(true);
        channel.setLightColor(Color.GREEN);
        // 设置通知出现时的震动（如果 android 设备支持的话）
        channel.enableVibration(true);
        //如上设置使手机：静止1秒，震动2秒，静止1秒，震动3秒
        channel.setVibrationPattern(new long[]{1000, 2000, 1000, 3000});

        //锁屏的时候是否展示通知
        channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
        notificationManager.createNotificationChannel(channel);
    }

    public void sendSimpleNotificationSecond() {
        int id = 1002;
        String channelId = "channel_second";

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentTitle("简单的通知的标题2")
                .setContentText("这是通知内容2")
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                .setAutoCancel(true)
                .setSmallIcon(R.mipmap.ic_launcher);


        //这里必须设置chanenelId,要不然该通知在8.0手机上，不能正常显示
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannelId(channelId);
            builder.setChannelId(channelId);
        }

        //发送通知
        notificationManager.notify(id, builder.build());
    }


}
