package com.example.a1kayat34.a2dgraphicsapp;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    class MyTask extends AsyncTask<Integer,Void,String>{

        @Override
        protected String doInBackground(Integer... params) {
            return null;
        }

        protected void onProgressUpdate(Integer... values) {
            int p = values[0];
            gv.postInvalidate();
        }
    }


    GraphicsView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gv = new GraphicsView(this);
        setContentView(gv);
    }

    public void onClick(View view)
    {
        MyTask task = new MyTask();
        task.execute();
    }
}
