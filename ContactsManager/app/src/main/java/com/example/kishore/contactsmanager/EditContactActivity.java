package com.example.kishore.contactsmanager;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditContactActivity extends AppCompatActivity {

    private EditText etName,etEmail;
    private Button btnEdit,btnDelete;
    private int id;
    DBService db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("_id");

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        btnEdit = (Button) findViewById(R.id.btnEdit);
        btnDelete = (Button) findViewById(R.id.btnDelete);

        db = new DBService(this);

        displayContact();
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this,ListAllContacts.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void displayContact() {
        Cursor cursor = db.getContact(id);
        String name="",email="";

        if(cursor.moveToFirst()) {
            name = cursor.getString(1);
            email = cursor.getString(2);
        }
        etName.setText(name);
        etEmail.setText(email);
    }

    public void editContact(View view){
        db.updateContact(id,etName.getText().toString(),etEmail.getText().toString());
        Toast.makeText(getBaseContext(),"Edited Successfully",Toast.LENGTH_SHORT).show();
    }

    public void deleteContact(View view){
        db.deleteContact(id);
        Toast.makeText(getBaseContext(),"Contact Deleted",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,ListAllContacts.class);
        startActivity(i);
        finish();
    }
}
