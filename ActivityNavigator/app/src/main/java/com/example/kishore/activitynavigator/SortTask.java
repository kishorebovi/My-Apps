package com.example.kishore.activitynavigator;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kishore on 11/7/2016.
 */

public class SortTask extends AsyncTask<int[],String,String[]> {

    private long start,end;
    private int view;
    private Activity activity;
    private TextView tvBubble,tvInsert,tvSelect,tvMerge,tvHeap,tvQuick,tvResult;

    public SortTask(Activity activity,int view){
        this.activity = activity;
        this.view = view;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        tvBubble=(TextView) activity.findViewById(R.id.tvBubble);
        tvInsert=(TextView) activity.findViewById(R.id.tvInsertion);
        tvSelect=(TextView) activity.findViewById(R.id.tvSelection);
        tvMerge=(TextView) activity.findViewById(R.id.tvMerge);
        tvHeap=(TextView) activity.findViewById(R.id.tvHeap);
        tvQuick=(TextView) activity.findViewById(R.id.tvQuick);
    }

    @Override
    protected String[] doInBackground(int[]... params) {

        String[] result=new String[6];
        int[] temp=params[0];
        switch (view){

            case R.id.btnBubble:
                tvResult=(TextView)activity.findViewById(R.id.tvBubble);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.bubble(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";
                return result;

            case R.id.btnSelection:
                tvResult=(TextView)activity.findViewById(R.id.tvSelection);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.selection(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";
                return result;

            case R.id.btnInsertion:
                tvResult=(TextView)activity.findViewById(R.id.tvInsertion);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.insertion(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";
                return result;

            case R.id.btnQuick:
                tvResult=(TextView)activity.findViewById(R.id.tvQuick);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.quick(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";
                return result;

            case R.id.btnMerge:
                tvResult=(TextView)activity.findViewById(R.id.tvMerge);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.mergeSort(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";
                return result;

            case R.id.btnHeap:
                tvResult=(TextView)activity.findViewById(R.id.tvHeap);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.heap(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";
                return result;

            case R.id.btnBench:
                tvResult=(TextView)activity.findViewById(R.id.tvBubble);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.bubble(temp);
                end=System.currentTimeMillis();
                result[0] = " "+(end-start)+" ms";

                tvResult=(TextView)activity.findViewById(R.id.tvSelection);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.selection(temp);
                end=System.currentTimeMillis();
                result[1] = " "+(end-start)+" ms";

                tvResult=(TextView)activity.findViewById(R.id.tvMerge);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.mergeSort(temp);
                end=System.currentTimeMillis();
                result[2] = " "+(end-start)+" ms";

                tvResult=(TextView)activity.findViewById(R.id.tvInsertion);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.insertion(temp);
                end=System.currentTimeMillis();
                result[3] = " "+(end-start)+" ms";

                tvResult=(TextView)activity.findViewById(R.id.tvQuick);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.quick(temp);
                end=System.currentTimeMillis();
                result[4] = " "+(end-start)+" ms";

                tvResult=(TextView)activity.findViewById(R.id.tvHeap);
                publishProgress("");
                start=System.currentTimeMillis();
                SortAlgorithms.heap(temp);
                end=System.currentTimeMillis();
                result[5] = " "+(end-start)+" ms";

                return  result;
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        tvResult.setText("Working..");
    }

    protected void onPostExecute(String[] text) {
        super.onPostExecute(text);
        if(text[1]==null)
        tvResult.setText(text[0]);
        else {
            tvBubble.setText(text[0]);
            tvSelect.setText(text[1]);
            tvInsert.setText(text[2]);
            tvQuick.setText(text[3]);
            tvMerge.setText(text[4]);
            tvHeap.setText(text[5]);
        }
    }
}

