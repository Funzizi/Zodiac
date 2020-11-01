package com.example.zodiac.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.zodiac.R;
import com.example.zodiac.controller.databases.DatabaseZodiac;
import com.example.zodiac.model.ZodiacDetails;

import java.util.ArrayList;
import java.util.List;

public class ZodiacActivity extends AppCompatActivity {
    private TextView tvName;
    private TextView tvDate;
    private TextView tvOverview;
    private TextView tvMale;
    private TextView tvFemale;
    private TextView tvSummary;

    private DatabaseZodiac database;
    private List<ZodiacDetails> list;
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zodiac);
        mapping();
        index = getIntent().getIntExtra("index", -1);
        database = new DatabaseZodiac(ZodiacActivity.this);
        list = new ArrayList<>();
        list.addAll(database.getZodiac());
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvName.setText(Html.fromHtml(list.get(index).getName()));
        tvDate.setText(Html.fromHtml(list.get(index).getDate()));
        tvOverview.setText(Html.fromHtml(list.get(index).getOverview()));
        tvMale.setText(Html.fromHtml(list.get(index).getMale()));
        tvFemale.setText(Html.fromHtml(list.get(index).getFemale()));
        tvSummary.setText(Html.fromHtml(list.get(index).getSummary()));
    }

    private void mapping(){
        tvName = findViewById(R.id.tv_name);
        tvDate = findViewById(R.id.tv_date);
        tvOverview = findViewById(R.id.tv_overview);
        tvMale = findViewById(R.id.tv_male);
        tvFemale = findViewById(R.id.tv_female);
        tvSummary = findViewById(R.id.tv_summary);
    }
}