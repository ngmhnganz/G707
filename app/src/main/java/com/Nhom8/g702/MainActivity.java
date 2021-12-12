package com.Nhom8.g702;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.Nhom8.adapter.SachAdapter;
import com.Nhom8.model.Sach;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lvSach;
    SachAdapter adapter;
    ArrayList<Sach> sachList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linkViews();
        initData();
        initAdapter();

    }

    private void linkViews() {
        lvSach=findViewById(R.id.lvSach);
    }

    private void initData() {
        sachList=new ArrayList<Sach>();
        //sachList.add(new Sach(01,"Sách 01","NXBTre",))
    }

    private void initAdapter() {
        adapter=new SachAdapter(MainActivity.this,R.layout.item_layout,sachList);
        lvSach.setAdapter(adapter);
    }
}