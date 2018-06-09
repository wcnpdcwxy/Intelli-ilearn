package com.edu360.ilearn.Vo;

public class PieVo {
    String type;
    int rate;

    @Override
    public String toString() {
        return "PieVo{" +
                "type='" + type + '\'' +
                ", rate=" + rate +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
