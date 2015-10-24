package com.example.customView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;

import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;


/**
 * Created by Administrator on 2015/10/12.
 */
public class RadarView extends View {
    float an = 0;
    Context mContext;
    private Paint circlePaint;
    DisplayMetrics metrics=new DisplayMetrics();

    private  int height;
    private  int width;
    /**也可以使用下面的新方法
     *DisplayMetrics dm =getResources().getDisplayMetrics();
     int w_screen = dm.widthPixels;
     int h_screen = dm.heightPixels;
     */
    private  Paint roundPaint = new Paint();
    private  Matrix m = new Matrix();

    private  Handler handler = new Handler();
     Runnable runnable = new Runnable() {
        @Override
        public void run() {
            m.postRotate(an++,width/2,height/2);
            handler.postDelayed(runnable, 50);
            invalidate();
        }
    };

    public RadarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext=context;

        init();
    }
    private void init() {
        ((Activity)mContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        height = metrics.heightPixels-16;
        width = metrics.widthPixels;
        circlePaint = new Paint();
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.parseColor("#004c55"));
        circlePaint.setStrokeWidth(3);
        circlePaint.setStyle(Paint.Style.STROKE);
        roundPaint.setAntiAlias(true);
        roundPaint.setDither(true);
        /**
         * 画圆的画笔不要设置颜色，后面再shader里面设置， SweepGradient为圆形渐变
         */
        Shader shader = new SweepGradient(width >> 1, height >> 1,Color.parseColor("#00ffaaff"), Color.parseColor("#fffaafff"));
        roundPaint.setShader(shader);
        roundPaint.setStyle(Paint.Style.FILL);
        handler.post(runnable);
    }
    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.concat(m);/*绑定matrix*/
        canvas.drawCircle(width >> 1, height >> 1, width / 2, roundPaint);
        m.reset();//重置matrix，防止越转越快
        canvas.drawCircle(width >> 1, height >> 1, width / 6, circlePaint);
                super.onDraw(canvas);
    }
}
