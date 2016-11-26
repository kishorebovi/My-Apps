package com.example.kishore.activitynavigator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * Created by Kishore on 10/17/2016.
 */

public class SMS_App extends AppCompatActivity {

        private EditText phone;
        private EditText message;
        private Button send;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.sms_layout);

            phone=(EditText)findViewById(R.id.etPhone);
            message=(EditText)findViewById(R.id.etText);
            send=(Button)findViewById(R.id.btn);

            send.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    sendSMSMessage();
                }
            });
        }

        protected void sendSMSMessage() {
            Log.i("Send SMS", "");
            String phoneNo = phone.getText().toString();
            String msg = message.getText().toString();

            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNo, null, msg, null, null);
                Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
            }

            catch (Exception e) {
                Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }


}
