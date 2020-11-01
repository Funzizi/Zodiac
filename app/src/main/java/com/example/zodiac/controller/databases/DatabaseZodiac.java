package com.example.zodiac.controller.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.zodiac.model.Love;
import com.example.zodiac.model.ZodiacDetails;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseZodiac extends SQLiteAssetHelper {
    private static final String database_Name = "zodiac.db";
    private static final int database_Version = 1;

    public DatabaseZodiac(Context context) {
        super(context, database_Name, null, database_Version);
    }

    // Lấy ra thông tin 12 cung hoàng đạo
    public List<ZodiacDetails> getZodiac(){
        List<ZodiacDetails> list = new ArrayList<>();
        try{
            String sqlQuery = "select * from horoscope_zodiacs";
            SQLiteDatabase database = getReadableDatabase();
            Cursor cursor = database.rawQuery(sqlQuery, null);
            while (cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String overview = cursor.getString(cursor.getColumnIndex("overview"));
                String male = cursor.getString(cursor.getColumnIndex("male"));
                String female = cursor.getString(cursor.getColumnIndex("female"));
                String summary = cursor.getString(cursor.getColumnIndex("summary"));
                list.add(new ZodiacDetails(name, date, overview, male, female, summary));
            }
        }
        catch (Exception e){
            Log.e("Error", e.toString());
        }
        return list;
    }

    // Lấy thông tin ghép đôi
    public List<Love> getLove(String maleZodiac, String femaleZodiac){
        List<Love> list = new ArrayList<>();
        try{
            String sqlQuery = "select * from fortune_tell_love_zodiac " +
                    "where (zodiac = '" + maleZodiac + "' and zodiac_partner = '" + femaleZodiac + "') " +
                    "or (zodiac = '" + femaleZodiac + "' and zodiac_partner = '" + maleZodiac + "')";
            SQLiteDatabase database = getReadableDatabase();
            Cursor cursor = database.rawQuery(sqlQuery, null);
            while (cursor.moveToNext()) {
                String content = cursor.getString(cursor.getColumnIndex("content"));
                String match = cursor.getString(cursor.getColumnIndex("match"));
                list.add(new Love(content, match));
            }
        }
        catch (Exception e){
            Log.e("Error", e.toString());
        }
        return list;
    }
}
