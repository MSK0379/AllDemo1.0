package com.example.msk.alldemo10;
/**
 * Created by MSK on 2017/3/15.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;

public class showActivity extends AppCompatActivity {
    private Button buttonback;

    //设置图片数组建议尺寸（）
    int[] imagerIds = new int[]{
        R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d };
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        buttonback = (Button) findViewById(R.id.backshow);
        //设置图片轮换
        flipper = (AdapterViewFlipper)findViewById(R.id.flipper);
        //创建BaseAdapter对象，该对象负责提供Gallery所显示的列表
        BaseAdapter adapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return imagerIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //创建一个ImageView
                ImageView imageView= new ImageView(showActivity.this);
                imageView.setImageResource(imagerIds[position]);
                //设置所缩放类型
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                //为其设置布局参数
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
        flipper.startFlipping();

        //控制返回主界面
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(showActivity.this, MainActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(it);
                //onKeyDown(KeyEvent.KEYCODE_BACK, null);

            }

        });

    }
}
