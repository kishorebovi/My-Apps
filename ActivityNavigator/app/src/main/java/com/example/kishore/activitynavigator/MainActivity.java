package com.example.kishore.activitynavigator;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton btn;
    private WifiManager wifiManager;
    private  int mId=1;

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void notify(View view){
        NotificationCompat.Builder mBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(this).setSmallIcon(R.drawable.xyz)
                .setContentTitle("My Notification").setContentText("Complete the Task!!!");
        Intent ResultIntent = new Intent(this,MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(ResultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(mId, mBuilder.build());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (ToggleButton) findViewById(R.id.tbWIFI);

        btn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if (checked) {

                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(true);
                } else {

                    WifiManager wifi = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                    wifi.setWifiEnabled(false);
                }
            }
        });
    }

    public void fbLogin(View view){
        Intent myIntent = new Intent(getBaseContext(),FaceBookLogin.class);
        startActivity(myIntent);
    }

    public void switchToGreet(View view){


        Intent myIntent = new Intent(getBaseContext(),GreetUserActivity.class);
        startActivity(myIntent);
    }

    public void switchToAlgoBenchmark(View view){
        Intent myIntent = new Intent(getBaseContext(),Algo_Benchmark.class);
        startActivity(myIntent);
    }

    public void switchToSimpleCalci(View view){
        Intent myIntent = new Intent(getBaseContext(),SimpleCalci.class);
        startActivity(myIntent);
    }

    public void switchToSMS(View view){
        Intent myIntent = new Intent(getBaseContext(),SMS_App.class);
        startActivity(myIntent);
    }

    public void switchToToast(View view){
        Intent myIntent = new Intent(this,ToastPlay.class);
        startActivity(myIntent);
    }
}
