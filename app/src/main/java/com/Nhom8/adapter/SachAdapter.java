package com.Nhom8.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.Nhom8.g702.R;
import com.Nhom8.model.Sach;

import java.util.List;

public class SachAdapter extends BaseAdapter {
    Activity context;
    int item_layout;
    List<Sach> sachList;

    public SachAdapter(Activity context, int item_layout, List<Sach> sachList) {
        this.context = context;
        this.item_layout = item_layout;
        this.sachList = sachList;
    }

    @Override
    public int getCount() {
        return sachList.size();
    }

    @Override
    public Object getItem(int i) {
        return sachList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item_layout, null );
            holder.imvAnh=view.findViewById(R.id.imvAnh);
            holder.txtTen=view.findViewById(R.id.txtTen);
            holder.txtNXB=view.findViewById(R.id.txtNXB);
            holder.txtSoLanTB=view.findViewById(R.id.txtSoLanTB);
            holder.txtGia=view.findViewById(R.id.txtGia);
            view.setTag(holder);
        }else {
            holder= (ViewHolder) view.getTag();
        }
        //biding data
        Sach sach=sachList.get(i);
        //SET IMAGE RESOURCE
        //holder.imvAnh.
//        BitmapDrawable drawable= (BitmapDrawable) holder.imvAnh.getDrawable();
//        Bitmap bitmap=drawable.getBitmap();
//        holder.imvAnh.setImageBitmap(bitmap);
        holder.txtTen.setText(sach.getName());
        holder.txtNXB.setText("Nhà xuất bản: "+sach.getNhaSanXuat());
        holder.txtGia.setText(String.valueOf(sach.getGia()));
        holder.txtSoLanTB.setText("Số lần tái bản: "+sach.getTaiBan());


        return view;
    }

    public static class ViewHolder{
        ImageView imvAnh;
        TextView txtTen, txtNXB,txtSoLanTB,txtGia;

    }
}
