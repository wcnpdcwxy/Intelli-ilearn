package com.edu360.ilearn.Vo;

public class PasswordVo {
    private int userId;
    private String oldpd;
    private String newpd;

    @Override
    public String toString() {
        return "PasswordVo{" +
                "userId=" + userId +
                ", oldpd=" + oldpd +
                ", newpd=" + newpd +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOldpd() {
        return oldpd;
    }

    public void setOldpd(String oldpd) {
        this.oldpd = oldpd;
    }

    public String getNewpd() {
        return newpd;
    }

    public void setNewpd(String newpd) {
        this.newpd = newpd;
    }
}