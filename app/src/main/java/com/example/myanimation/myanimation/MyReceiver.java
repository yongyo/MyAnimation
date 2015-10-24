package com.example.myanimation.myanimation;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;


public class MyReceiver extends BroadcastReceiver {

    private String mi=null;
    public void setMi(String mi) {
        this.mi = mi;
    }


    public MyReceiver() {
    }
    public String getMi() {
        return mi;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("ninini")) {
            setMi(intent.getAction());
            String  widgetText = (String) android.text.format.DateFormat.format("yy-MM-dd hh-mm-ss EEE,zzzz",new Date());
            AppWidgetManager appWidgetManager=AppWidgetManager.getInstance(context);
            ComponentName cm=new ComponentName(context,NewAppWidget.class);
            Toast.makeText(context,"ninini"+"==="+mi+(new Date()),Toast.LENGTH_LONG).show();
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
            views.setTextViewText(R.id.appwidget_text, widgetText);
            appWidgetManager.updateAppWidget(cm,views);
        }else{}
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
//        throw new UnsupportedOperationException("Not yet implemented");
    }
}