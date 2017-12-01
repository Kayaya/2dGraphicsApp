package com.example.a1kayat34.a2dgraphicsapp;

import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    GraphicsView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gv = new GraphicsView(this);
        setContentView(gv);
    }

    public void onClick(View view) {
       /* MyTask task = new MyTask();
        task.execute();*/
    }
}
