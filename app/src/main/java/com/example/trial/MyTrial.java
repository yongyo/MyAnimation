package com.example.trial;

import android.content.Context;
import android.util.Log;

import com.example.bean.Mroot;
import com.example.bean.People;
import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2015/10/4.
 */
public class MyTrial {
        Context mContext;
    public String ooo;
    public MyTrial(Context c) {
        mContext=c;
    }

    private final OkHttpClient client = new OkHttpClient();


//    public void run() throws Exception {
//        Request request = new Request.Builder()
//                .url("http://publicobject.com/helloworld.txt")
//                .build();
//
//        client.newCall(request).enqueue(new Callback() {
//
//
//            @Override
//            public void onFailure(Request request, IOException e) {
//                e.printStackTrace();
//            }
//
//            @Override
//            public void onResponse(Response response) throws IOException {
//                if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);
//
//                Headers responseHeaders = response.headers();
//                for (int i = 0; i < responseHeaders.size(); i++) {
//                    System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//                }
//
//                System.out.println(response.body().string());
//            }
//        });
//
//    }
    public void run() throws Exception{

        final Request request=new Request.Builder()
//                .url("http://publicobject.com/helloworld.txt")
                .url("http://m.weather.com.cn/atad/101010100.html")
                .build();
        Call call=client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Headers headers=response.headers();

                for (int i=0;i<headers.size();i++){
                    System.out.println(headers.name(i) + "::::" + headers.value(i));
                }
               ooo=response.body().string();
//                System.out.println(response.body().string());

                System.out.println(ooo);
                String aaa=ooo.replace("\"","\\\"" );//又可以用了，奇怪
                System.out.println(aaa);

                Gson gson = new Gson();


                People pp1 = new People();
                Mroot root = new Mroot();
//                root=gson.fromJson(aaa,Mroot.class);
//                Log.e("PPPPP", root.getWeatherinfo().getCity());
//
                }
        });
    }
}
