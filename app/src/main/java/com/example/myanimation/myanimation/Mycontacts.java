package com.example.myanimation.myanimation;

import android.app.ActionBar;
import android.content.Context;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.text.util.Rfc822Token;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bean.People;
import com.example.trial.MyAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;
import in.srain.cube.views.ptr.header.RentalsSunHeaderView;
import in.srain.cube.views.ptr.header.StoreHouseHeader;

public class Mycontacts extends ActionBarActivity {
    private ListView myList;
    ContentResolver mContentResolver;
     List<People> list;
    private MyAdapter myAdapter;
    PtrFrameLayout ptla;


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mycontacts);
        Toolbar toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("联系人");
        toolbar.setNavigationIcon(R.mipmap.actionbar_white_back_icon);
        toolbar.setLogo(R.mipmap.meet_home_setting_icon_normal);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        list=new ArrayList<People>();
        myList= (ListView) findViewById(R.id.myList);
        ptla= (PtrFrameLayout) findViewById(R.id.store_house_ptr_frame);
        //mPtrFrame = (PtrClassicFrameLayout) contentView.findViewById(R.id.xxxxx);  classic帧布局是经典式下拉刷新，默认加载头部布局，不需要创建







/**
 * //太阳头部刷新

        final RentalsSunHeaderView header = new RentalsSunHeaderView(ptla.getContext());
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, 12, 0, 10);
        header.setUp(ptla);
*/
        // Metrial 头部header
        final MaterialHeader header = new MaterialHeader(ptla.getContext());
        int[] colors = getResources().getIntArray(R.array.google_colors);
        header.setColorSchemeColors(colors);
        header.setLayoutParams(new PtrFrameLayout.LayoutParams(-1, -2));
        header.setPadding(0, 15, 0, 15);
        header.setPtrFrameLayout(ptla);






        ptla.setLoadingMinTime(1000);
        ptla.setDurationToCloseHeader(1500);
        ptla.setHeaderView(header);
        ptla.addPtrUIHandler(header);
       ptla.setPullToRefresh(true);

        //自动刷新
        /*
        ptla.postDelayed(new Runnable() {
            @Override
            public void run() {
                ptla.autoRefresh(false);
            }
        }, 100);
        */
        ptla.setPtrHandler(new PtrHandler() {

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {

                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }


            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        ptla.refreshComplete();
                    }
                }, 1800);

            }
        });

        myAdapter=new MyAdapter(list,this);
        myList.setAdapter(myAdapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s=list.get(position).getPhoneNumber();

                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+s));
                startActivity(intent);
            }
        });
        myList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String s=list.get(position).getPhoneNumber();
                Uri uri = Uri.parse("smsto:"+s);
                Intent it = new Intent(Intent.ACTION_SENDTO, uri);
//                it.putExtra("sms_body", "");
                startActivity(it);
                return false;
            }
        });




//        Uri uri = Uri.parse("content://com.android.contacts/raw_contacts");

        mContentResolver = getContentResolver();
        Cursor cursor = mContentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, null, null, null);
        if(list != null){ list.clear();}
        Log.e("-------->>>>>>>","woyun");
        int i = 0;
        if (cursor != null) {

            while (cursor.moveToNext()) {
                i++;
                String contact_id = cursor.getString(0);
                if (TextUtils.isEmpty(contact_id)) {
                    continue;
                }

//                Cursor cursor1 = mContentResolver.query(Uri.parse("content://com.android.contacts/data"), new String[]{"data1", "mimetype"}, "contact_id=?", new String[]{contact_id}, null);
                People people = new People();
                people.setName(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
                people.setPhoneNumber(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY)));
                people.setPhoneNumber(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                people.setSort_key(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.SORT_KEY_PRIMARY)));
//
//                while (cursor1.moveToNext()) {
//                    String data1 = cursor.getString(0);
//                    String mimetype = cursor1.getString(1);
//                    if ("vnd.android.cursor.item/name".equals(mimetype)) {
//                        people.setName(data1);
//
//                    } else if ("vnd.android.cursor.item/phone_v2".equals(mimetype))  {
//                        people.setPhoneNumber(data1);
//                    } else if("vnd.android.cursor.item/postal-address_v2".equals(mimetype))  {
//                        people.setAddress(data1);
//
//                    }
                    list.add(people);
//                    try
//                    {
//                        //4.0以上的版本会自动关闭 (4.0--14;; 4.0.3--15)
//                        if(Integer.parseInt(Build.VERSION.SDK) < 14)
//                        {
//                            cursor1.close();
//                        }
//                    }catch(Exception e)
//                    {
//                        Log.e("_____________>>>", "error:" + e);
//                    }

                }
                try
                {
                if(Integer.parseInt(Build.VERSION.SDK) < 14)
                {
                    cursor.close();
                }
            }catch(Exception e)
            {
                Log.e("_____________>>>", "error:" + e);
            }
            Collections.sort(list, new Comparator<People>() {
                @Override
                public int compare(People lhs, People rhs) {
                    return getSortKey(lhs.getSort_key()).compareToIgnoreCase(getSortKey(rhs.getSort_key()));
                }
            });
            }

        }

    private  String getSortKey(String sortKeyString) {
        String key = sortKeyString.substring(0, 1).toUpperCase();
        if (key.matches("[A-Z]")) {
            return key;
        }
        return "#";

    }
    @Override
    protected void onResume() {

        super.onResume();
    }
}
