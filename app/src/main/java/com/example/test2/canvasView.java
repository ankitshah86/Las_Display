package com.example.test2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class canvasView extends View {

    Context context;
    int width, height;
    Bitmap bitmap;
    Paint paint;
    Path path;
    Canvas canvas;
    float mX, mY;
    static final float TOLERANCE = 4;

    public canvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        path = new Path();
       // path.lineTo(0,0);
       // path.lineTo(500,500);
       // path.lineTo(1000,1000);


        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(255,0,0));
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        path.setFillType(Path.FillType.WINDING);

        paint.setColor(Color.rgb(125,125,125));
        paint.setStrokeWidth(2);
        for(int i = 0;i < 10; i++ ){
            path.moveTo(i*50,0);
            path.lineTo(i*50,4000);
        }
        invalidate();

        paint.setStrokeWidth(10);
        paint.setAntiAlias(true);
        paint.setColor(Color.rgb(0,0,255));

        for(int i = 0; i < 100; i++){
            if(i == 0) path.moveTo(((float)Math.random()) * 400,i * 40 );
            path.lineTo(((float)Math.random()) * 500,i * 40 );
        }
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
        Log.d("Width and hwight" + String.valueOf(canvas.getWidth()),String.valueOf(canvas.getHeight()));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("mouse Events",String.valueOf( event.getX())+ String.valueOf(event.getY())) ;

        if(event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_UP)
        path.moveTo(event.getX(),event.getY());
        else if(event.getAction() == MotionEvent.ACTION_MOVE)
            path.lineTo(event.getX(),event.getY());
        invalidate();


        //return super.onTouchEvent(event);
        return true;
    }
}
