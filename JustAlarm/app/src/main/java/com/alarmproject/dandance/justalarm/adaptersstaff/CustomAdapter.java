package com.alarmproject.dandance.justalarm.adaptersstaff;


import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alarmproject.dandance.justalarm.R;
import com.alarmproject.dandance.justalarm.database.ObjectItem;

import java.util.GregorianCalendar;

public class CustomAdapter extends CursorAdapter {
    //private List<ObjectItem> data;
    //private Context context;

    //public CustomAdapter(Context context, List<ObjectItem> data) {
    //    super(context, R.layout.custom_adapter_listview);
    //    this.data = data;
    //    this.context = context;
    //}

    private ObjectItem item;
    private LayoutInflater cursorInflater;

    public CustomAdapter(Context ctx, Cursor cursor){
        super(ctx, cursor,0);
        cursorInflater = (LayoutInflater) ctx.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        item = new ObjectItem();
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return cursorInflater.inflate(R.layout.custom_adapter_listview, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView title = (TextView)view.findViewById(R.id.title);
        TextView time = (TextView)view.findViewById(R.id.time);
        //ImageView thumbImage = (ImageView)view.findViewById(R.id.imageView);

        item.setInfo(cursor);

        title.setText(item.getTitle());
        time.setText(GregorianCalendar.getInstance().getTime().toString());
        //thumbImage.setImageDrawable();
    }

//    @Override
//    public int getCount() {
//        // возвращаем количество элементов списка
//        return data.size();
//    }
//
//    @Override
//    public String getItem(int position) {
//        // получение одного элемента по индексу
//        return data.get(position).getTitle();
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    // заполнение элементов списка
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        // задаем вид элемента списка, который мы создали выше
//        View view = inflater.inflate(R.layout.custom_adapter_listview, parent, false);
//
//        // проставляем данные для элементов
//        TextView title = (TextView)view.findViewById(R.id.title);
//        TextView time = (TextView)view.findViewById(R.id.time);
//        ImageView thumbImage = (ImageView)view.findViewById(R.id.imageView);
//
//        // получаем элемент со списка
//        ObjectItem objectItem = data.get(position);
//
//        // устанавливаем значения компонентам одного эелемента списка
//        title.setText(objectItem.getTitle());
//        time.setText(objectItem.getDate().toString());
//        thumbImage.setImageDrawable(objectItem.getImage());
//
//        return view;
//    }
}
