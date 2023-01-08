package com.example.carbonegy2;



import java.util.Calendar;

public class RecordedEmission {
    private Calendar date;
    private int emissions;

    public RecordedEmission(Calendar date, int emissions) {
        this.date = date;
        this.emissions = emissions;
    }

    public Calendar getDate() {
        return date;
    }

    public int getEmissions() {
        return emissions;
    }
}
