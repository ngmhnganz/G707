package com.Nhom8.g702;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ListView;

import com.Nhom8.adapter.SachAdapter;
import com.Nhom8.model.Sach;

import java.util.ArrayList;
import java.util.List;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.Nhom8.model.Sach;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyDatabaseHelper db;
    ArrayList<Sach> saches;

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
        getMenuInflater().inflate(R.menu.additem_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.mnAdd){
            openAddDialog();
        }
        return super.onOptionsItemSelected(item);
    }
    private void openAddDialog() {
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialogadd);

        EditText  edtName,
                edtNXB,
                edtSLTB,
                edtGia;
        Button btnOk,
                btnHuy;
        ImageView itemimg;
        edtName = dialog.findViewById(R.id.edtGia);
        edtNXB = dialog.findViewById(R.id.edtNXB);
        edtSLTB = dialog.findViewById(R.id.edtSLTB);
        edtGia = dialog.findViewById(R.id.edtGia);
        btnOk = dialog.findViewById(R.id.btnOk);
        btnHuy = dialog.findViewById(R.id.btnHuy);
        itemimg = dialog.findViewById(R.id.imvItem);


        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskName=edtName.getText().toString();
                if(taskName.equals("")){
                    Toast.makeText(MainActivity.this, "Nhập tên", Toast.LENGTH_SHORT).show();
                }else if(edtNXB.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Nhập nhà sản xuất", Toast.LENGTH_SHORT).show();}
                    else if(edtSLTB.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Nhập số lượng", Toast.LENGTH_SHORT).show();}
                    else if(edtGia.getText().toString().equals("")){
                        Toast.makeText(MainActivity.this, "Nhập giá", Toast.LENGTH_SHORT).show();}
                    else {
                        long stl = Long.parseLong(edtSLTB.getText().toString());
                        double gia = Double.parseDouble(edtGia.getText().toString());
                        boolean flag = db.insertData(edtName.getText().toString(), edtNXB.getText().toString(), stl, gia, convertPhoto(itemimg));
                        if (flag){

                        }
                            Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
//                            startActivity(intent);
                        }
                }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

    private byte[] convertPhoto(ImageView imv) {
        BitmapDrawable drawable = (BitmapDrawable) imv.getDrawable();
        Bitmap bitmap = drawable.getBitmap();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        return outputStream.toByteArray();
    }

}