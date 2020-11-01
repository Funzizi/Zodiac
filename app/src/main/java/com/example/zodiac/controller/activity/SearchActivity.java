package com.example.zodiac.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zodiac.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SearchActivity extends AppCompatActivity {
    private EditText edtYear;
    private TextView tvDate;
    private Button btSearch;

    private int Date, Month, Year;
    private String[] zodiacList = {"Bạch Dương", "Kim Ngưu", "Song Tử", "Cự Giải", "Sư Tử", "Xử Nữ",
                                    "Thiên Bình", "Bọ Cạp", "Nhân Mã", "Ma Kết", "Bảo Bình", "Song Ngư"};
    private int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mapping();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtYear.getText().toString().isEmpty())
                    Toast.makeText(SearchActivity.this, "Vui lòng nhập năm trước!", Toast.LENGTH_SHORT).show();
                else {
                    Year = Integer.parseInt(edtYear.getText().toString());
                    if(Year > 1900 && Year < 2020) dateChoose();
                    else Toast.makeText(SearchActivity.this, "Năm bạn nhập không đúng \nVui lòng nhập lại!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvDate.getText().toString() != "") {
                    Intent intent = new Intent(SearchActivity.this, ZodiacActivity.class);
                    switch (Month) {
                        case 1:
                            if (Date < 21) index = 9;
                            else index = 10;
                            break;
                        case 2:
                            if (Date < 20) index = 10;
                            else index = 11;
                            break;
                        case 3:
                            if (Date < 21) index = 11;
                            else index = 0;
                            break;
                        case 4:
                            if (Date < 21) index = 0;
                            else index = 1;
                            break;
                        case 5:
                            if (Date < 22) index = 1;
                            else index = 2;
                            break;
                        case 6:
                            if (Date < 22) index = 2;
                            else index = 3;
                            break;
                        case 7:
                            if (Date < 24) index = 3;
                            else index = 4;
                            break;
                        case 8:
                            if (Date < 23) index = 4;
                            else index = 5;
                            break;
                        case 9:
                            if (Date < 24) index = 5;
                            else index = 6;
                            break;
                        case 10:
                            if (Date < 24) index = 6;
                            else index = 7;
                            break;
                        case 11:
                            if (Date < 23) index = 7;
                            else index = 8;
                            break;
                        case 12:
                            if (Date < 22) index = 8;
                            else index = 9;
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + Month);
                    }
                    Toast.makeText(SearchActivity.this, "Bạn thuộc cung " + zodiacList[index],
                            Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            intent.putExtra("index", index);
                            startActivity(intent);
                        }
                    }, 2000);
                }
                else Toast.makeText(SearchActivity.this, "Hãy nhập đầu đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Chọn ngày sinh
    private void dateChoose() {
        Calendar calendar = Calendar.getInstance();
        int dayNow = calendar.get(Calendar.DATE);
        int monthNow = calendar.get(Calendar.MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(SearchActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Date = dayOfMonth;
                Month = month + 1;
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                tvDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, Year, monthNow, dayNow);
        datePickerDialog.show();
    }

    private void mapping() {
        edtYear = findViewById(R.id.edt_year);
        tvDate = findViewById(R.id.tv_date);
        btSearch = findViewById(R.id.bt_search);
    }
}