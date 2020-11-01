package com.example.zodiac.controller.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zodiac.R;
import com.example.zodiac.model.Mission;

import java.util.ArrayList;
import java.util.List;

public class gvAdapterMore extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Mission> list = new ArrayList<>();

    public gvAdapterMore(Context context, int layout, List<Mission> list) {
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
        private ImageView imvMore;
        private TextView tvMore;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null){
            // Lấy Context để có thể hiển thị Vd : MenuActivity
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // View dùng để chứa layout
            view = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();
            // Ánh xạ View
            viewHolder.imvMore = view.findViewById(R.id.imv_more);
            viewHolder.tvMore = view.findViewById(R.id.tv_more);
            view.setTag(viewHolder);        // Giữ trạng thái ánh xạ cho view
        }
        else {
            // Truyền vào trạng thái ánh xạ
            viewHolder = (ViewHolder) view.getTag();
        }
        // Gán giá trị
        Mission mission = list.get(i);
        viewHolder.imvMore.setImageResource(mission.getPhoto());
        viewHolder.tvMore.setText(mission.getName());
        return view;
    }
}
