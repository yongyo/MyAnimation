package com.example.myanimation.myanimation;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import java.util.logging.LogRecord;

public class MyService extends Service {
    Context context;
    Handler handler=new Handler();

    public MyService() {
    }

    public MyService(Context context) {
        this.context=context;


    }

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @Override
    public void onCreate() {
        super.onCreate();


        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(context);
                ComponentName cm=new ComponentName(context,NewAppWidget.class);
                String  widgetText = (String) android.text.format.DateFormat.format("yy-MM-dd hh-mm-ss EEE,zzzz",new Date());
                RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
                views.setTextViewText(R.id.appwidget_text, widgetText);
                appWidgetManager.updateAppWidget(cm, views);
                handler.postDelayed(this,1000);
            }
        };
        handler.post(runnable);
    }



    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }
}
