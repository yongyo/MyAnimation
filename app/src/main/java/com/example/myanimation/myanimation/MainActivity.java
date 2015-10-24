package com.example.myanimation.myanimation;


import android.appwidget.AppWidgetManager;

import android.content.ComponentName;

import android.content.ContentResolver;
import android.content.Intent;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import com.example.bean.People;
import com.example.circle_image.Constants;
import com.example.customView.RadarView;
import com.example.trial.MyTrial;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import java.util.Date;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView imageView;
    private Button button;
    private Button tolist;
    private List<People> list;
    AppWidgetManager awm;
    private static final String[] IMAGE_URLS = Constants.IMAGES;
    int i = 0;
    MyReceiver mReceiver;
    ContentResolver contentResolver;
    RadarView radarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView) findViewById(R.id.iv_my);
        button = (Button) findViewById(R.id.btn_my);
        tolist = (Button) findViewById(R.id.tolist);
        imageView.setBackgroundResource(R.drawable.circle);
        radarView= (RadarView) findViewById(R.id.rada);
        awm = AppWidgetManager.getInstance(this);
        mReceiver = new MyReceiver();
        tolist.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Mycontacts.class);
                startActivity(intent);
            }
        });
        button.setOnClickListener((new OnClickListener() {


            /**
             * Called when a view has been clicked.
             *
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                MyTrial myTrial = new MyTrial(MainActivity.this);
//                People ppp = new People("nini", "wowo", "tata");
//                Gson gson = new Gson();
//                String uuu = gson.toJson(ppp);
//                Log.e("uuu", uuu);
//                People pp1 = new People();
//                Mroot root = new Mroot();
//                System.out.println("---------------+++++++++++++" + uuu);
//                root = gson.fromJson("{\"weatherinfo\":{\"city\":\"北京\",\"city_en\":\"beijing\",\"date_y\":\"2015年6月18日\",\"date\":\"\",\"week\":\"星期四\",\"fchh\":\"11\",\"cityid\":\"101010100\",\"temp1\":\"32℃~19℃\",\"temp2\":\"28℃~17℃\",\"temp3\":\"32℃~20℃\",\"temp4\":\"32℃~21℃\",\"temp5\":\"31℃~20℃\",\"temp6\":\"33℃~21℃\",\"tempF1\":\"89.6℉~66.2℉\",\"tempF2\":\"82.4℉~62.6℉\",\"tempF3\":\"89.6℉~68℉\",\"tempF4\":\"89.6℉~69.8℉\",\"tempF5\":\"87.8℉~68℉\",\"tempF6\":\"91.4℉~69.8℉\",\"weather1\":\"多云转雷阵雨\",\"weather2\":\"雷阵雨转晴\",\"weather3\":\"晴\",\"weather4\":\"多云\",\"weather5\":\"多云转晴\",\"weather6\":\"晴转多云\",\"img1\":\"1\",\"img2\":\"4\",\"img3\":\"4\",\"img4\":\"0\",\"img5\":\"0\",\"img6\":\"99\",\"img7\":\"1\",\"img8\":\"99\",\"img9\":\"1\",\"img10\":\"0\",\"img11\":\"0\",\"img12\":\"1\",\"img_single\":\"1\",\"img_title1\":\"多云\",\"img_title2\":\"雷阵雨\",\"img_title3\":\"雷阵雨\",\"img_title4\":\"晴\",\"img_title5\":\"晴\",\"img_title6\":\"晴\",\"img_title7\":\"多云\",\"img_title8\":\"多云\",\"img_title9\":\"多云\",\"img_title10\":\"晴\",\"img_title11\":\"晴\",\"img_title12\":\"多云\",\"img_title_single\":\"多云\",\"wind1\":\"北风3-4级转微风\",\"wind2\":\"微风\",\"wind3\":\"微风\",\"wind4\":\"微风\",\"wind5\":\"微风\",\"wind6\":\"微风\",\"fx1\":\"北风\",\"fx2\":\"微风\",\"fl1\":\"3-4级转小于3级\",\"fl2\":\"小于3级\",\"fl3\":\"小于3级\",\"fl4\":\"小于3级\",\"fl5\":\"小于3级\",\"fl6\":\"小于3级\",\"index\":\"炎热\",\"index_d\":\"天气炎热，建议着短衫、短裙、短裤、薄型T恤衫等清凉夏季服装。\",\"index48\":\"\",\"index48_d\":\"\",\"index_uv\":\"中等\",\"index48_uv\":\"\",\"index_xc\":\"不宜\",\"index_tr\":\"适宜\",\"index_co\":\"较不舒适\",\"st1\":\"31\",\"st2\":\"17\",\"st3\":\"25\",\"st4\":\"18\",\"st5\":\"31\",\"st6\":\"21\",\"index_cl\":\"较适宜\",\"index_ls\":\"适宜\",\"index_ag\":\"不易发\"}}", Mroot.class);
//                Log.e("PPPPP", root.getWeatherinfo().getCityid());
                try {
                    myTrial.run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                initImage();
            }

            private void initImage() {
                DisplayImageOptions options = new DisplayImageOptions.Builder()
                        .showImageOnLoading(R.mipmap.loading)
                        .showImageForEmptyUri(R.mipmap.empty)
                        .showImageOnFail(R.mipmap.error)
                        .cacheInMemory(true)
                        .cacheOnDisk(true)
                        .considerExifParams(true)
                        .displayer(new RoundedBitmapDisplayer(5))
                        .build();
                ImageLoader loader = ImageLoader.getInstance();

                if (i == IMAGE_URLS.length) {
                    i = 0;
                }
                loader.displayImage(IMAGE_URLS[i++], imageView, options);

            }
        }));

        final Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mReceiver.getMi()) {
                    button.setText(mReceiver.getMi());
                }
          /*
          上面的mReceiver.getMi()获取到的Mi一般都是null，因为此时，recrive生命周期已经结束了，所以获取不到值
           */
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.leftout);
                ComponentName cm = new ComponentName(MainActivity.this, NewAppWidget.class);
                RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.new_app_widget);
                String m = DateFormat.format("yyyy-MM-dd hh-mm-ss", new Date()).toString();
                remoteViews.setTextViewText(R.id.appwidget_text, m);


                awm.updateAppWidget(cm, remoteViews);
                imageView.startAnimation(animation);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camara) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}

