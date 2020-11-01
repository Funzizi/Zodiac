package com.example.zodiac.model;

public class ZodiacDetails {
    private String name;
    private String date;
    private String overview;
    private String male;
    private String female;
    private String summary;

    public ZodiacDetails(String name, String date, String overview, String male, String female, String summary) {
        this.name = name;
        this.date = date;
        this.overview = overview;
        this.male = male;
        this.female = female;
        this.summary = summary;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getOverview() {
        return overview;
    }

    public String getMale() {
        return male;
    }

    public String getFemale() {
        return female;
    }

    public String getSummary() {
        return summary;
    }
}
