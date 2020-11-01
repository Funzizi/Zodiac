package com.example.zodiac.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.zodiac.R;
import com.example.zodiac.controller.activity.ZodiacActivity;
import com.example.zodiac.controller.adapter.gvAdapterZodiac;
import com.example.zodiac.model.Zodiac;

import java.util.ArrayList;
import java.util.List;

public class ZodiacFragment extends Fragment {
    private GridView gridView;
    private List<Zodiac> list = new ArrayList<>();
    com.example.zodiac.controller.adapter.gvAdapterZodiac gvAdapterZodiac;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zodiac, container, false);
        gridView = view.findViewById(R.id.gv_zodiac);
        gvAdapterZodiac = new gvAdapterZodiac(getActivity(), R.layout.item_gridview_zodiac, list);
        gridView.setAdapter(gvAdapterZodiac);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ZodiacActivity.class);
                intent.putExtra("index", position);
                startActivity(intent);
            }
        });
        return view;
    }

    private void addList() {
        list.add(new Zodiac(R.drawable.bach_duong_1, "Bạch Dương", "21/3 - 19/4"));
        list.add(new Zodiac(R.drawable.kim_nguu_2, "Kim Ngưu", "20/4 - 20/5"));
        list.add(new Zodiac(R.drawable.song_tu_3, "Song Tử", "21/5 - 21/6"));
        list.add(new Zodiac(R.drawable.cu_giai_4, "Cự Giải", "22/6 - 22/7"));
        list.add(new Zodiac(R.drawable.su_tu_5, "Sư Tử", "23/7 - 22/8"));
        list.add(new Zodiac(R.drawable.xu_nu_6, "Xử Nữ", "23/8 - 22/9"));
        list.add(new Zodiac(R.drawable.thien_binh_7, "Thiên Bình", "23/9 - 22/10"));
        list.add(new Zodiac(R.drawable.bo_cap_8, "Thiên Yết", "23/10- 21/11"));
        list.add(new Zodiac(R.drawable.nhan_ma_9, "Nhân Mã", "22/11 - 21/12"));
        list.add(new Zodiac(R.drawable.ma_ket_10, "Ma Kết", "22/12 - 19/1"));
        list.add(new Zodiac(R.drawable.bao_binh_11, "Bảo Bình", "20/1 - 18/2"));
        list.add(new Zodiac(R.drawable.song_ngu_12, "Song Ngư", "19/2 - 20/3"));
    }
}