package com.edu360.ilearn.Tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getTime(String type){
        long currentTime = System.currentTimeMillis();

        SimpleDateFormat formatter = null;
        if(type=="long"){
            formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        }
        if(type=="time"){
            formatter = new SimpleDateFormat("HH-mm-ss");
        }
        if(type=="date"){
            formatter = new SimpleDateFormat("yyyy-MM-dd");
        }

        Date date = new Date(currentTime);

        return formatter.format(date);
    }
}
