package com.example.zodiac.controller.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zodiac.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoveActivity extends AppCompatActivity {
    private EditText edtYearMale;
    private TextView tvDateMale;
    private EditText edtYearFemale;
    private TextView tvDateFemale;
    private Button btCheck;

    private int DateMale, MonthMale, Year, DateFemale, MonthFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_love);
        mapping();
    }

    @Override
    protected void onResume() {
        super.onResume();
        tvDateMale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtYearMale.getText().toString().isEmpty())
                    Toast.makeText(LoveActivity.this, "Vui lòng nhập năm trước!", Toast.LENGTH_SHORT).show();
                else {
                    Year = Integer.parseInt(edtYearMale.getText().toString());
                    if(Year > 1900 && Year < 2020) dateChooseMale();
                    else Toast.makeText(LoveActivity.this, "Năm bạn nhập không đúng \nVui lòng nhập lại!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvDateFemale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtYearFemale.getText().toString().isEmpty())
                    Toast.makeText(LoveActivity.this, "Vui lòng nhập năm trước!", Toast.LENGTH_SHORT).show();
                else {
                    Year = Integer.parseInt(edtYearFemale.getText().toString());
                    if(Year > 1900 && Year < 2020) dateChooseFemale();
                    else Toast.makeText(LoveActivity.this, "Năm bạn nhập không đúng \nVui lòng nhập lại!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
        btCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvDateMale.getText().toString() != "" && tvDateFemale.getText().toString() != ""){
                    int indexMale = checkZodiac(DateMale, MonthMale);
                    int indexFemale = checkZodiac(DateFemale, MonthFemale);
                    int[] index = {indexMale, indexFemale};
                    Intent intent = new Intent(LoveActivity.this, ShowLoveActivity.class);
                    intent.putExtra("index", index);
                    startActivity(intent);
                }
                else Toast.makeText(LoveActivity.this, "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Xem cung hoàng đạo
    private int checkZodiac(int Date, int Month){
        int index;
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
        return index;
    }

    // Chọn ngày sinh cho bạn nam
    private void dateChooseMale() {
        Calendar calendar = Calendar.getInstance();
        int dayNow = calendar.get(Calendar.DATE);
        int monthNow = calendar.get(Calendar.MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(LoveActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                tvDateMale.setText(simpleDateFormat.format(calendar.getTime()));
                DateMale = dayOfMonth;
                MonthMale = month + 1;
            }
        }, Year, monthNow, dayNow);
        datePickerDialog.show();
    }

    // Chọn ngày sinh cho bạn nữ
    private void dateChooseFemale() {
        Calendar calendar = Calendar.getInstance();
        int dayNow = calendar.get(Calendar.DATE);
        int monthNow = calendar.get(Calendar.MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(LoveActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM");
                tvDateFemale.setText(simpleDateFormat.format(calendar.getTime()));
                DateFemale = dayOfMonth;
                MonthFemale = month + 1;
            }
        }, Year, monthNow, dayNow);
        datePickerDialog.show();
    }

    private void mapping() {
        edtYearMale = findViewById(R.id.edt_year_male);
        tvDateMale = findViewById(R.id.tv_date_male);
        edtYearFemale = findViewById(R.id.edt_year_female);
        tvDateFemale = findViewById(R.id.tv_date_female);
        btCheck = findViewById(R.id.bt_check);
    }
}