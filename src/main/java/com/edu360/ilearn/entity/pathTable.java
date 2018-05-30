package com.edu360.ilearn.entity;

public class pathTable {
    private String ip;
    private String userId;
    private String userName;
    private String earlyTime;
    private String earlyPath = "/index";
    private int longTime;
    private String longTimePath;
    private String lastTime;
    private String lastPath;
    private int pathCount;


    public String getEarlyPath() {
        return earlyPath;
    }

    public String getAvgTime() {
        String[] split1 = lastTime.split(" ")[1].split(":");
        String lasthour = split1[0];
        String lastminute = split1[1];
        String lastsecond = split1[2];

        String[] split2 = earlyTime.split(" ")[1].split(":");
        String earlyhour = split2[0];
        String earlyminute = split2[1];
        String earlysecond = split2[2];

        int lasttime = Integer.parseInt(lasthour) * 3600 + Integer.parseInt(lastminute) * 60 + Integer.parseInt(lastsecond);
        int earlytime = Integer.parseInt(earlyhour) * 3600 + Integer.parseInt(earlyminute) * 60 + Integer.parseInt(earlysecond);
        int time = lasttime - earlytime;

        int round = Math.round(time / pathCount);

        return round/60+"m"+round%60+"s";
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEarlyTime() {
        return earlyTime;
    }

    public void setEarlyTime(String earlyTime) {
        this.earlyTime = earlyTime;
    }

    public String getLongTime() {
        return longTime/60+"m"+longTime%60;
    }

    public void setLongTime(int longTime) {
        this.longTime = longTime;
    }

    public String getLongTimePath() {
        return longTimePath;
    }

    public void setLongTimePath(String longTimePath) {
        this.longTimePath = longTimePath;
    }

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastPath() {
        return lastPath;
    }

    public void setLastPath(String lastPath) {
        this.lastPath = lastPath;
    }

    public int getPathCount() {
        return pathCount;
    }

    public void setPathCount(int pathCount) {
        this.pathCount = pathCount;
    }
}
