package com.example.zodiac.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zodiac.R;
import com.example.zodiac.model.Zodiac;

import java.util.List;

public class gvAdapterZodiac extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Zodiac> list;

    public gvAdapterZodiac(Context context, int layout, List<Zodiac> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        private ImageView imvphoto;
        private TextView tvZodiacName;
        private TextView tvZodiacDate;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            // Lấy Context để có thể hiển thị Vd : MenuActivity
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // View dùng để chứa layout
            view = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            // Ánh xạ View
            viewHolder.imvphoto = view.findViewById(R.id.imv_zodiac);
            viewHolder.tvZodiacName = view.findViewById(R.id.tv_zodiac_name);
            viewHolder.tvZodiacDate = view.findViewById(R.id.tv_zodiac_date);
            view.setTag(viewHolder);        // Giữ trạng thái ánh xạ cho view
        }
        else {
            // Truyền vào trạng thái ánh xạ
            viewHolder = (ViewHolder) view.getTag();
        }
        // Gán giá trị
        Zodiac zodiac = list.get(i);
        viewHolder.imvphoto.setImageResource(zodiac.getPhoto());
        viewHolder.tvZodiacName.setText(zodiac.getName());
        viewHolder.tvZodiacDate.setText(zodiac.getDate());
        return view;
    }
}