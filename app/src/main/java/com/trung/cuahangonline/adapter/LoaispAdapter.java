package com.trung.cuahangonline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.trung.cuahangonline.R;
import com.trung.cuahangonline.model.LoaiSP;

import java.util.ArrayList;


public class LoaispAdapter extends BaseAdapter {
    ArrayList<LoaiSP> arrayListLoaisp;
    Context context;

    public LoaispAdapter(ArrayList<LoaiSP> arrayListLoaisp, Context context) {
        this.arrayListLoaisp = arrayListLoaisp;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayListLoaisp.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListLoaisp.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public class ViewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.txttenloaisp = (TextView) view.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp=(ImageView) view.findViewById(R.id.imageview);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        //lay du lieu
        LoaiSP loaisp=(LoaiSP)getItem(i);
        viewHolder.txttenloaisp.setText(loaisp.getTenloaisp());
        Picasso.with(context).load(loaisp.getHinhanhloaisp())
                .placeholder(R.drawable.nophoto)
                .error(R.drawable.cancel)
                .into(viewHolder.imgloaisp);

        return view;
    }
}
