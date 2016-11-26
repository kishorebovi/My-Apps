package com.example.kishore.activitynavigator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;

/**
 * Created by Kishore on 10/12/2016.
 */

public class SimpleCalci extends AppCompatActivity {

    private EditText etNum1;
    private EditText etNum2;
    private EditText tvResult;
    private double num1;
    private double num2;

    public void add(View view){
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(),"Enter the Numbers",Toast.LENGTH_LONG).show();
        }
        double res=num1+num2;
        String temp=Double.toString(res);
        tvResult.setText(temp);
    }

    public  void subtract(View view){
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(),"Enter the Numbers",Toast.LENGTH_LONG).show();
        }
        double res=num1-num2;
        String temp=Double.toString(res);
        tvResult.setText(temp);
    }

    public void multiply(View view){
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(),"Enter the Numbers",Toast.LENGTH_LONG).show();
        }
        double res=num1*num2;
        String temp=Double.toString(res);
        tvResult.setText(temp);
    }

    public void divide(View view){
        try {
            num1 = Double.parseDouble(etNum1.getText().toString());
            num2 = Double.parseDouble(etNum2.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(),"Enter the Numbers",Toast.LENGTH_LONG).show();
        }
        if(num2>0) {
            double res = num1 / num2;
            String temp=Double.toString(res);
            tvResult.setText(temp);
        }else{
            Toast.makeText(getBaseContext(),"Cant divide by zero",Toast.LENGTH_LONG).show();
        }


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        etNum1=(EditText)findViewById(R.id.etNum1);
        etNum2=(EditText)findViewById(R.id.etNum2);
        tvResult=(EditText)findViewById(R.id.etResult);

    }
}
