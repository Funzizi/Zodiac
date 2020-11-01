package com.example.zodiac.model;

public class Zodiac {
    private int photo;
    private String name;
    private String date;

    public Zodiac(int photo, String name, String date) {
        this.photo = photo;
        this.name = name;
        this.date = date;
    }

    public int getPhoto() {
        return photo;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
