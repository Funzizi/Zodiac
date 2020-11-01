package com.example.zodiac.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.zodiac.R;
import com.example.zodiac.controller.databases.DatabaseZodiac;
import com.example.zodiac.model.Love;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowLoveActivity extends AppCompatActivity {
    private TextView tvZodiac;
    private TextView tvContent;
    private TextView tvHarmony;

    private String[] zodiacList = {"Bạch Dương", "Kim Ngưu", "Song Tử", "Cự Giải", "Sư Tử", "Xử Nữ",
                            "Thiên Bình", "Thiên Yết", "Nhân Mã", "Ma Kết", "Bảo Bình", "Song Ngư"};
    private int[] index;

    DatabaseZodiac database;
    private List<Love> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_love);
        mapping();
        index = getIntent().getIntArrayExtra("index");
        database = new DatabaseZodiac(ShowLoveActivity.this);
        list.addAll(database.getLove(zodiacList[index[0]], zodiacList[index[1]]));
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvZodiac.setText("Nam " + zodiacList[index[0]] + " và Nữ " + zodiacList[index[1]]);
        tvContent.setText(Html.fromHtml(list.get(0).getContent()));
        Random random = new Random();
        int harmony;
        switch (list.get(0).getMatch()){
            case "Hợp":
                harmony = new Random().nextInt(41) + 60;
                break;
            case "Bình Thường":
                harmony = new Random().nextInt(21) + 40;
                break;
            case "Không Hợp":
                harmony = new Random().nextInt(41);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + list.get(0).getMatch());
        }
        tvHarmony.setText("Độ Hợp : " + harmony +"%");
    }

    private void mapping() {
        tvZodiac = findViewById(R.id.tv_zodiac);
        tvContent = findViewById(R.id.tv_content);
        tvHarmony = findViewById(R.id.tv_harmony);
    }
}