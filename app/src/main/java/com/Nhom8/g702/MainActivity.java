package com.Nhom8.g702;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.Nhom8.model.Sach;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper db;
    ArrayList<Sach> saches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private void createDB() {
        db=new MyDatabaseHelper(this);
//        db.createDefaultSomeTasks();
    }

    private void loadData() {
        saches=new ArrayList<>();
        Cursor cursor=db.getData("SELECT * FROM " + MyDatabaseHelper.TBL_NAME);
        saches.clear();
        while(cursor.moveToNext()){
            saches.add(new Sach(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getLong(3), cursor.getDouble(4),cursor.getBlob(5)));
        }
        cursor.close();

//        adapter=new TaskAdapter(this,R.layout.item_list,tasks);
//        lvTask.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnAdd){
            //Open dialog for adding task
//            openAddDialog();
        }
        return super.onOptionsItemSelected(item);
    }

}