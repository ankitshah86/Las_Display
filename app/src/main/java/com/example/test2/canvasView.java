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
        path.lineTo(0,0);
        path.lineTo(500,500);
        path.lineTo(1000,1000);

        paint = new Paint();
        paint.setColor(Color.rgb(255,0,0));
        paint.setStrokeWidth(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        Log.d("mouse Events",String.valueOf( event.getX())+ String.valueOf(event.getY())) ;
        path.lineTo(event.getX(),event.getY());
        invalidate();
        //return super.onTouchEvent(event);
        return true;
    }
}
