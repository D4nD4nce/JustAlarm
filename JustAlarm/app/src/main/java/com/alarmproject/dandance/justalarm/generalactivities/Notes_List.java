package com.alarmproject.dandance.justalarm.generalactivities;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.alarmproject.dandance.justalarm.R;
import com.alarmproject.dandance.justalarm.adaptersstaff.CustomAdapter;
import com.alarmproject.dandance.justalarm.adaptersstaff.ObjectItem;
import com.alarmproject.dandance.justalarm.enums.IMGEnum;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Notes_List extends AppCompatActivity {

    private ListView listView;
    private CustomAdapter adapter;
    private TypedArray images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes__list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Инициализируем изображения с помощью ресурса изображений
        // данный ресурс будет рассмотрен ниже
        Resources res = getResources();
        images = res.obtainTypedArray(R.array.images);

        listView = (ListView) findViewById(R.id.list);

        // инициализация нашего адаптера
        adapter = new CustomAdapter(this, initData());
        listView.setAdapter(adapter);

        // По клику будем выводить текст элемента
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), adapter.getItem(position).toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Этот медот будет инициализировать список даных для ListView
    private ArrayList<ObjectItem> initData() {
        // ObjectItem это наш POJO объект который мы ниже разберем.
        // Даный список будет возвращаться для заполнения LIstView
        ArrayList<ObjectItem> maps = new ArrayList<ObjectItem>();

        ObjectItem objectItem1 = new ObjectItem("Test 1",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.DONE.index()));

        maps.add(objectItem1);

        ObjectItem objectItem2 = new ObjectItem("Test 2",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem2);

        ObjectItem objectItem3 = new ObjectItem("Test 3",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.DONE.index()));

        maps.add(objectItem3);

        ObjectItem objectItem4 = new ObjectItem("Test 4",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.DONE.index()));

        maps.add(objectItem4);

        ObjectItem objectItem5 = new ObjectItem("Test 5",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem5);

        ObjectItem objectItem6 = new ObjectItem("Test 6",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem6);

        ObjectItem objectItem7 = new ObjectItem("Test 7",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem7);

        ObjectItem objectItem8 = new ObjectItem("Test 8",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem8);

        ObjectItem objectItem9 = new ObjectItem("Test 9",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem9);

        ObjectItem objectItem10 = new ObjectItem("Test 10",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem10);

        ObjectItem objectItem11 = new ObjectItem("Test 11",
                GregorianCalendar.getInstance().getTime(),
                images.getDrawable(IMGEnum.NOTDONE.index()));

        maps.add(objectItem11);

        return maps;
    }

}
