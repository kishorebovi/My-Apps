package com.example.kishore.algobenchmark;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RadioGroup complexity;
    private RadioButton caseSelected;
    private EditText arrSize;
    private int[] arr;
    private Button b7;
    private int selectedId,size;
    private String ch;
    private TextView arrayDis;
    private long start,end;
    private TextView tvBubble,tvInsert,tvSelect,tvMerge,tvHeap,tvQuick;
    private GridLayout grid;
    private MenuItem itSettings,itHelp,itAbout;

    public void generateArray(View view){
        grid=(GridLayout)findViewById(R.id.gridLayout);
        complexity=(RadioGroup)findViewById(R.id.rgComplexity);
        selectedId = complexity.getCheckedRadioButtonId();
        arrSize=(EditText)findViewById(R.id.etArraySize);
        caseSelected=(RadioButton)findViewById(selectedId);
        arrayDis=(TextView)findViewById(R.id.tvArrayResult);
        ch= (String) caseSelected.getText();

        try {
            size = Integer.parseInt(arrSize.getText().toString());
        }catch (NumberFormatException e){
            Toast.makeText(getBaseContext(),"Enter the array size bro", Toast.LENGTH_LONG).show();
            return;
        }
        if(size<=0){
            Toast.makeText(getBaseContext(),"Array size should be greater than zero bro..!!", Toast.LENGTH_LONG).show();
            return;
        }


        switch(ch){
            case "Best Case":
                arr=new int[size];
                for(int i=0;i<size;i++)
                    arr[i]=i+1;
                arrayDis.setText("Array generated in Best Case for size "+size);
                grid.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);
                //Toast.makeText(getBaseContext(),Arrays.toString(arr), Toast.LENGTH_SHORT).show();
                break;

            case "Avg Case":
                arr=new int[size];
                for(int i=0;i<size;i++){
                    arr[i]=(int)(Math.random()*100);
                }
                arrayDis.setText("Array generated in Avg Case for size "+size);
                grid.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);
                //  Toast.makeText(getBaseContext(),Arrays.toString(arr), Toast.LENGTH_SHORT).show();
                break;
            case "Worst Case":
                arr=new int[size];
                int j=0;
                for(int i=size;i>0;i--){
                    arr[j++]=i;
                }
                arrayDis.setText("Array generated in Worst Case for size "+size);
                grid.setVisibility(View.VISIBLE);
                b7.setVisibility(View.VISIBLE);
                //Toast.makeText(getBaseContext(),Arrays.toString(arr), Toast.LENGTH_SHORT).show();
                break;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);//Menu Resource, Menu
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itSettings:
                Toast.makeText(getApplicationContext(),"Settings Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.itHelp:
                Toast.makeText(getApplicationContext(),"Help Selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.itAbout:
                Toast.makeText(getApplicationContext(),"About Selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        itSettings=(MenuItem)findViewById(R.id.itSettings);
        itHelp=(MenuItem)findViewById(R.id.itHelp);
        itAbout=(MenuItem)findViewById(R.id.itAbout);

        Button b1= (Button) findViewById(R.id.btnBubble);
        Button b2= (Button) findViewById(R.id.btnSelection);
        Button b3= (Button) findViewById(R.id.btnInsertion);
        Button b4= (Button) findViewById(R.id.btnQuick);
        Button b5= (Button) findViewById(R.id.btnMerge);
        Button b6= (Button) findViewById(R.id.btnHeap);
        b7= (Button) findViewById(R.id.btnBench);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        tvBubble=(TextView)findViewById(R.id.tvBubble);
        tvSelect=(TextView)findViewById(R.id.tvSelection);
        tvInsert=(TextView)findViewById(R.id.tvInsertion);
        tvQuick=(TextView)findViewById(R.id.tvQuick);
        tvMerge=(TextView)findViewById(R.id.tvMerge);
        tvHeap=(TextView)findViewById(R.id.tvHeap);


    }

    @Override
    public void onClick(View v) {

        int[] temp=new int[arr.length];

        switch (v.getId()){

            case R.id.btnBubble:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.bubble(temp);
                end=System.currentTimeMillis();
                tvBubble.setText(end-start+"ms");
                break;

            case R.id.btnSelection:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.selection(temp);
                end=System.currentTimeMillis();
                tvSelect.setText(end-start+"ms");
                break;

            case R.id.btnInsertion:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.insertion(temp);
                end=System.currentTimeMillis();
                tvInsert.setText(end-start+"ms");
                break;

            case R.id.btnQuick:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.quick(temp);
                end=System.currentTimeMillis();
                tvQuick.setText(end-start+"ms");
                break;

            case R.id.btnMerge:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.mergeSort(temp);
                end=System.currentTimeMillis();
                tvMerge.setText(end-start+"ms");
                break;

            case R.id.btnHeap:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.heap(temp);
                end=System.currentTimeMillis();
                tvHeap.setText(end-start+"ms");
                break;

            case R.id.btnBench:
                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.bubble(temp);
                end=System.currentTimeMillis();
                tvBubble.setText(end-start+"ms");

                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.selection(temp);
                end=System.currentTimeMillis();
                tvSelect.setText(end-start+"ms");

                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.mergeSort(temp);
                end=System.currentTimeMillis();
                tvMerge.setText(end-start+"ms");

                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.insertion(temp);
                end=System.currentTimeMillis();
                tvInsert.setText(end-start+"ms");

                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.quick(temp);
                end=System.currentTimeMillis();
                tvQuick.setText(end-start+"ms");

                temp=arr.clone();
                start=System.currentTimeMillis();
                SortAlgorithms.heap(temp);
                end=System.currentTimeMillis();
                tvHeap.setText(end-start+"ms");

                break;
        }
    }
}
