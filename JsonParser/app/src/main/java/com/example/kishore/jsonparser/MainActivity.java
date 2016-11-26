package com.example.kishore.jsonparser;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //json string
    private String jsonString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            jsonString = returnJson();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        initList();
        ListView listView = (ListView) findViewById(R.id.listView1);
        ListAdapter adapter = new SimpleAdapter(
                MainActivity.this, employeeList,
                R.layout.list_view, new String[]{"song_name", "artist","year"},
                new int[]{R.id.song, R.id.artist,R.id.year});
        listView.setAdapter(adapter);
    }


    ArrayList<HashMap<String, String>> employeeList = new ArrayList<>();
    private void initList(){

        try{
            JSONObject jsonResponse = new JSONObject(jsonString);
            JSONArray jsonMainNode = jsonResponse.optJSONArray("employee");

            for(int i = 0; i<jsonMainNode.length();i++){
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                String name = jsonChildNode.optString("song_name");
                String artist = jsonChildNode.optString("artist");
                String year = jsonChildNode.optString("year");

                HashMap<String,String> song = new HashMap<>();

                song.put("song_name",name);
                song.put("artist",artist);
                song.put("year",year);
                employeeList.add(song);
            }
        }
        catch(JSONException e){
            Toast.makeText(getApplicationContext(), "Error"+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public  String returnJson() throws FileNotFoundException {

        String json = null;
        try {

            AssetManager mng = getAssets();
            InputStream is = mng.open("jason.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}