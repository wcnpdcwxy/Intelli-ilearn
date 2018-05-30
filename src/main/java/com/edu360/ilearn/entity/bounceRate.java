package com.edu360.ilearn.entity;

public class bounceRate {
    private String date;
    private int alonePath;
    private int totalPath;
    private double rate;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAlonePath() {
        return alonePath;
    }

    public void setAlonePath(int alonePath) {
        this.alonePath = alonePath;
        if(alonePath!=0&&totalPath!=0){
            rate = alonePath/totalPath;
        }
    }

    public int getTotalPath() {
        return totalPath;
    }

    public void setTotalPath(int totalPath) {
        this.totalPath = totalPath;
        if(alonePath!=0&&totalPath!=0){
            rate = alonePath/totalPath;
        }
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "bounceRate{" +
                "date='" + date + '\'' +
                ", alonePath=" + alonePath +
                ", totalPath=" + totalPath +
                ", rate=" + rate +
                '}';
    }
}
