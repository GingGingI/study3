package com.example.a309.ssgwajes;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private static final int Dialog_Yes_No_Message = 1;
    private static final int Notification_ID = 1;
    Button Btn1,Btn2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Btn1 = (Button)findViewById(R.id.Btn1);
        Btn2 = (Button)findViewById(R.id.Btn2);

        Btn1.setOnClickListener(this);
        Btn2.setOnClickListener(this);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case Dialog_Yes_No_Message :
                AlertDialog.Builder builder
                        = new AlertDialog.Builder(this);

                builder.setTitle("끌꺼얌??")
                        .setMessage("진짜로???")
                        .setCancelable(false)
                        .setPositiveButton("ㅇㅇㅇㅇ",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        MainActivity.this.finish();
                                    }
                                })
                        .setNegativeButton("ㄴㄴㄴㄴ",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                return alert;
        }
        return null;
    }

    public void sendNotification(View view) {

        //NotificationCompat.Builder를 사용하여 알림을 설정
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

        //알림에 나타나는 아이콘.
        builder.setSmallIcon(R.mipmap.ic_launcher);

        //알림클릭시 이 인텐트가 보내짐
        Intent intent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.google.com/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                intent, 0);

        //사용자가 알림 클릭시 인텐트가 보내짐.
        builder.setContentIntent(pendingIntent);

        //알림에 표시되는 큰 아이콘
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),
                R.mipmap.ic_launcher));

        //알림제목
        builder.setContentTitle("앱안에있는 버튼을 누름(제목)");

        //알람 내용
        builder.setContentText("진짜로 눌렀나봐;;;(내용)");

        //버젼4.2이상이면 알려지는 서브텍스트
        builder.setSubText("구글로 이동할꺼임 ㅇㅇ(보이면 버젼4.2이상)");

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);

        //알림바에 알람표시
        notificationManager.notify(Notification_ID, builder.build());
    }

    public void onClick (View v) {
        switch (v.getId()){
            case R.id.Btn1 :
                showDialog(Dialog_Yes_No_Message);
                break;
            case R.id.Btn2 :
                Snackbar snackbar = Snackbar.make(v, "스낵바 버튼 눌렀음", Snackbar.LENGTH_LONG)
                        .setAction("ㅇㅋ", new View.OnClickListener() {
                            @Override
                            public void onClick(View V) {
                                Toast.makeText(MainActivity.this, "그랬구나", Toast.LENGTH_SHORT).show();
                            }
                        });

                snackbar.show();
                break;
        }
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

        if (id == R.id.nav_camera) {
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
