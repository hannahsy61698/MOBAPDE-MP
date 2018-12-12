package com.example.user.mp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class Game3 extends Activity {

    /*protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game3);

        Button temp = new Button(this);
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Game4.class);
                startActivityForResult(myIntent, 0);
            }
        });
    }


    */


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.stitch);


        setContentView(new MyView(this, bitmap));
    }

    public class MyView extends View implements View.OnTouchListener {

        private static final float TOUCH_TOLERANCE = 4;
        private Paint mPaint;
        private Bitmap oBitmap;
        private Bitmap holder;
        private Canvas mCanvas;
        private Path mPath;
        private Paint mBitmapPaint;
        private float mX, mY;

        private Button btn;


        public MyView(Context context) {
            super(context);
        }

        public MyView(Context context, Bitmap bitmap) {
            super(context);
            setOnTouchListener(this);
            this.oBitmap = bitmap;
            this.mPaint = new Paint();
            mPath = new Path();
            mBitmapPaint = new Paint(Paint.DITHER_FLAG);
            init();
        }

        protected void init() {
            mPaint.setAntiAlias(true);
            mPaint.setDither(true);
            mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeJoin(Paint.Join.ROUND);
            mPaint.setStrokeCap(Paint.Cap.ROUND);
            mPaint.setStrokeWidth(35);
        }

        @Override
        protected void onSizeChanged(int w, int h, int oldw, int oldh) {
            super.onSizeChanged(w, h, oldw, oldh);
            holder = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
            mCanvas = new Canvas(holder);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            onDrawing(canvas);
        }

        private void onDrawing(Canvas canvas) {
            mCanvas.drawColor(0xFFAAAAAA);
            mCanvas.drawPath(mPath, mPaint);
            canvas.drawBitmap(oBitmap, getWidth() / 2, getHeight() / 2, mBitmapPaint);
            canvas.drawBitmap(holder, 0, 0, mBitmapPaint);
        }

        private void touch_start(float x, float y) {
            mPath.moveTo(x, y);
            mX = x;
            mY = y;
        }

        private void touch_move(float x, float y) {
            float dx = Math.abs(x - mX);
            float dy = Math.abs(y - mY);
            if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
                mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2);
                mX = x;
                mY = y;
            }
        }

        private void touch_up() {
            mPath.lineTo(mX, mY);
            mCanvas.drawPath(mPath, mPaint);
        }


        @Override
        public boolean onTouch(View view, MotionEvent event) {
            float x = event.getX();
            float y = event.getY();

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    touch_start(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    touch_move(x, y);
                    invalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    touch_up();
                    invalidate();
                    break;
            }
            return true;

        }
    }
}
