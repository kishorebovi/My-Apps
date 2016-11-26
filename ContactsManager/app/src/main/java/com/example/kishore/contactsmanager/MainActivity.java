package com.example.kishore.contactsmanager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etName,etEmail;
    private Button btnAdd,btnToast,btnList;

    private DBService db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnToast = (Button) findViewById(R.id.btnToast);
        btnList = (Button) findViewById(R.id.btnList);

        db = new DBService(this);
    }

    public void insertIntoDB(View view){
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        if(name.equals("") || email.equals("")){
            Toast.makeText(getApplicationContext(),"Enter all fields",Toast.LENGTH_SHORT).show();
            return;
        }
        db.insertContact(name,email);
        Toast.makeText(getApplicationContext(),"Added Successfully",Toast.LENGTH_SHORT).show();
    }

    public void toastAll(View view){

        Toast.makeText(getApplicationContext(),db.getAllContacts(),Toast.LENGTH_LONG).show();
    }

    public void listAll(View view){
        Intent intent = new Intent(this,ListAllContacts.class);
        startActivity(intent);
        finish();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitByBackKey();

            //moveTaskToBack(false);

            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    protected void exitByBackKey() {

        AlertDialog alertbox = new AlertDialog.Builder(this)
                .setMessage("Do you want to exit application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {

                        finish();
                        //close();


                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {

                    // do something when the button is clicked
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                })
                .show();

    }
}
