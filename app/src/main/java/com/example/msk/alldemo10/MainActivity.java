package com.example.msk.alldemo10;
/**
 * Created by MSK on 2017/3/10.
 */
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.msk.alldemo10.userLogin.Langing;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button intohelpBtn;
    private Button intoshowBtn;
    private Button intocallBtn;
    private Button intouserbtn;
    TimeThread timeThread = new TimeThread();

    private TextView Mytime;
    private TextView Mydate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timeThread.start(); //启动新的线程
        setContentView(R.layout.activity_main);
        intohelpBtn = (Button) findViewById(R.id.intohelp);
        intocallBtn = (Button) findViewById(R.id.intocall);
        intoshowBtn = (Button) findViewById(R.id.intoshow);
        intouserbtn = (Button) findViewById(R.id.intouser);
        //获取控件
        Mydate = (TextView) findViewById(R.id.Mydate);
        Mytime = (TextView) findViewById(R.id.Mytime);
        //主页面按钮的监听
        intohelpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, Help.class);
                startActivity(it);
            }
        });
        intocallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, Family.class);
                startActivity(it);
            }
        });
        intoshowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, showActivity.class);
                startActivity(it);
            }
        });
        intouserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, Langing.class);
                startActivity(it);
            }
        });
    }
    class TimeThread extends Thread {
        @Override
        public void run() {
            do {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what = 1;  //消息(一个整型值)
                    mHandler.sendMessage(msg);// 每隔1秒发送一个msg给mHandler
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } while (true);
        }
    }

    //在主线程里面处理消息并更新UI界面
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    long sysTime = System.currentTimeMillis();
                    CharSequence sysDateStr = DateFormat.format("yyyy-MM-dd", sysTime);
                    CharSequence sysTimeStr = DateFormat.format("HH:mm:ss", sysTime);//HH返回24进制，hh返回12进制
//                    CharSequence sysDemoStr = DateFormat.format("yyyy-MM-dd HH-mm-ss", sysTime);//HH返回24进制，hh返回12进制
                    Mytime.setText(sysTimeStr); //更新时间
                    Mydate.setText(sysDateStr);

                    break;
                default:
                    break;

            }
        }
    };
}
