package com.example.zodiac.controller.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.zodiac.R;
import com.example.zodiac.controller.activity.LoveActivity;
import com.example.zodiac.controller.activity.SearchActivity;
import com.example.zodiac.controller.adapter.gvAdapterMore;
import com.example.zodiac.model.Mission;

import java.util.ArrayList;
import java.util.List;

public class MoreFragment extends Fragment {
    private GridView gridView;
    private List<Mission> list = new ArrayList<>();
    gvAdapterMore adapterMore;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        gridView = view.findViewById(R.id.gv_more);
        adapterMore = new gvAdapterMore(getActivity(), R.layout.item_gridview_more, list);
        gridView.setAdapter(adapterMore);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0:
                            startActivity(new Intent(getActivity(), SearchActivity.class));
                            break;
                        case 1:
                            startActivity(new Intent(getActivity(), LoveActivity.class));
                            break;
                    }
            }
        });
        return view;
    }

    private void addList(){
        list.add(new Mission(R.drawable.search, "Kiểm tra"));
        list.add(new Mission(R.drawable.love, "Bói tình duyên"));
    }
}