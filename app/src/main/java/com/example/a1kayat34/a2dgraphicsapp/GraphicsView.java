package com.example.a1kayat34.a2dgraphicsapp;

/**
 * Created by 1kayat34 on 27/11/2017.
 */
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;

public class GraphicsView extends View implements View.OnTouchListener{
    class MyTask extends AsyncTask<Void,Float,String> {

        float herox, heroy, x_direction;
        @Override
        protected String doInBackground(Void... unused) {
            herox = 0;
            heroy = 0;
            x_direction = 0;


            long time = System.currentTimeMillis();

            boolean isRunning = true;
            while(isRunning) {
                if (time + 10 < System.currentTimeMillis()) {
                    if(herox < 200 && x_direction == 0){
                        herox++;


                    }
                    else{
                        x_direction = 1;
                        if(herox >=0 && x_direction == 1){
                            herox--;
                        }
                        else{
                            x_direction = 0;
                        }
                    }
                    time = System.currentTimeMillis();


                    //Send the x and y coordinates to the main thread
                    publishProgress(herox, heroy);
                }
            }

            return null;
        }

        protected void onProgressUpdate(Float... progress) {

            x = progress[0];
            y = progress[1];

            //force to redraw the view
            postInvalidate();

        }
    }


    Paint p;
    int counter = 0;
    Bitmap heroBmp;


    float x,y;

    MyTask task;

    public GraphicsView (Context ctx)
    {
        super(ctx);

       p = new Paint();
        p.setColor(Color.RED);
        p.setTextSize(24);

        heroBmp = BitmapFactory.decodeResource(ctx.getResources(),R.drawable.hero);
        this.setOnTouchListener(this);
        task = new MyTask();

        task.execute();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();
       v.postInvalidate();
        return true;
    }

    public void onDraw (Canvas canvas)
    {
        counter++;
        p.setStyle(Paint.Style.FILL);
        //draw rect
        //canvas.drawRect(10, 10, 110, 110, p);
        canvas.drawText("The screen has been represhed"+counter, 0, 200, p);

        canvas.drawBitmap(heroBmp,  x, y, null);

    }


}
