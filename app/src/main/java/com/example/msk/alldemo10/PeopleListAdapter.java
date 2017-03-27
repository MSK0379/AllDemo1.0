package com.example.msk.alldemo10;

/**
 * Created by MSK on 2017/3/19.
 */
import android.content.Context;
import android.database.Cursor;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class PeopleListAdapter extends CursorAdapter{
    private LayoutInflater mInflater;

    public String number;

    int i  = 0;
    public PeopleListAdapter(Context context, Cursor c) {
        super(context, c);
        mInflater = LayoutInflater.from(context);
    }

    //设置item页面的布局效果
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder = new ViewHolder();
        //获取到对应的控件对象
        viewHolder.peopleImage = (ImageView) view.findViewById(R.id.image);
        viewHolder.PeopleName = (TextView) view.findViewById(R.id.name);
        viewHolder.peopleNumber = (TextView) view.findViewById(R.id.phone);
        //给控件对象设置相应的内容
        //cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_ID));
       viewHolder.peopleImage.setBackgroundResource(R.drawable.ic_launcher);
        //viewHolder.peopleImage.setBackgroundResource(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI));
        viewHolder.PeopleName.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)));
        viewHolder.peopleNumber.setText(cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return mInflater.inflate(R.layout.list_item, parent, false);
    }

    //定义内部类作为占位符组合
    class ViewHolder{
        ImageView peopleImage;
        TextView PeopleName;
        TextView peopleNumber;

    }



}