package com.example.kishore.activitynavigator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Kishore on 10/12/2016.
 */

public class GreetUserActivity extends AppCompatActivity{
    private EditText etFirstName;
    private EditText etLastName;
    private TextView tvResult;

    public void greetUser(View view){
        String fName = etFirstName.getText().toString();
        String lName = etLastName.getText().toString();
        tvResult.setText("Greetings   "+fName+" "+lName);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.greet_user_layout);
        etFirstName = (EditText) findViewById(R.id.etFirstName);
        etLastName = (EditText) findViewById(R.id.etLastName);
        tvResult = (TextView) findViewById(R.id.tvResult);

    }
}
