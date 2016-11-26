package com.example.kishore.activitynavigator;


import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MassageApp extends AppCompatActivity {

    private Button b1, b2, b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.massage_layout);

        b1 = (Button)findViewById(R.id.btn1);
        b2 = (Button)findViewById(R.id.btn2);
        b3 = (Button)findViewById(R.id.btn3);

    }

    public void Action(View view){

        switch (view.getId()){

            case R.id.btn1:
                Vibrator v1 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v1.vibrate(100);
                Toast.makeText(getBaseContext(), "Short Massage", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn2:
                Vibrator v21 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v21.vibrate(500);
                Toast.makeText(getBaseContext(), "Long Massage", Toast.LENGTH_SHORT).show();

                break;
            case R.id.btn3:
                Vibrator v3 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                v3.vibrate(1000);
                Toast.makeText(getBaseContext(), "Average Massage", Toast.LENGTH_SHORT).show();

                break;

        }
    }
}



