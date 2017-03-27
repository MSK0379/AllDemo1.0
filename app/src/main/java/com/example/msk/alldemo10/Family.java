package com.example.msk.alldemo10;
/**
 * Created by MSK on 2017/3/19.
 */
import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

/**
 *
 */
public class Family extends Activity implements OnItemClickListener {
    private ListView lv;
    private Cursor cursor;
    private PeopleListAdapter adapter;//适配器变量
    Button buttonback; //返回键

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        lv = (ListView) findViewById(R.id.listlx);
        //获取返回按键
        buttonback = (Button) findViewById(R.id.backcall);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(Family.this, MainActivity.class);
                it.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(it);
                //onKeyDown(KeyEvent.KEYCODE_BACK, null);
            }

        });
        //根据getcontentresolver获取手机联系人的信息
        cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
        //将可选内容与arrayadapter联系起来
        adapter = new PeopleListAdapter(this, cursor);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);//设置点击打电话
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(MainActivity.this, view+"", 1).show();
        TextView textview = (TextView) view.findViewById(R.id.phone);
        String number = textview.getText().toString();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            return;
        }
        startActivity(intent);

    }

}