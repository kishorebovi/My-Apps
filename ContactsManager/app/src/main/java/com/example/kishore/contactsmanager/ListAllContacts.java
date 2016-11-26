package com.example.kishore.contactsmanager;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAllContacts extends AppCompatActivity {

    DBService db;
    private ListView listContacts;
    Cursor cursor;
    ArrayList<HashMap<String, String>> contactList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_contacts);

        listContacts = (ListView) findViewById(R.id.listContacts);
        db = new DBService(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        listDB();

        listContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                HashMap x = (HashMap) adapterView.getItemAtPosition(i);
                int ids = Integer.parseInt((String) x.get("_id"));
               Intent intent = new Intent(getApplicationContext(), EditContactActivity.class);
               intent.putExtra("_id", ids);
               startActivity(intent);
               finish();

            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void listDB() {

        cursor = db.getAllContacts(1);

        if(cursor.moveToFirst()){
            do{
                HashMap<String,String> contact = new HashMap<>();

                contact.put("_id",cursor.getString(0));
                contact.put("name",cursor.getString(1));
                contact.put("email",cursor.getString(2));

                contactList.add(contact);
            }while (cursor.moveToNext());
        }

        ListAdapter adapter = new SimpleAdapter(
                ListAllContacts.this, contactList,
                R.layout.list_view, new String[]{"name", "email"},
                new int[]{R.id.name, R.id.email});
        listContacts.setAdapter(adapter);
    }
}
