package com.edu360.ilearn.Tool;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.edu360.ilearn.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

public class HttpPostUtil {
    private static CloseableHttpClient client;

    private static CloseableHttpClient getClient() {
        if(client == null){
            client = HttpClients.createMinimal();
            System.out.println("newClient");
        }
        return client;
    }

    private static void killClient() throws IOException {
        client.close();
        client = null;
    }

    public static String sendLog(String line,String path) {
        String url = "http://192.168.209.12:80/kafka/"+path;
        try {
            CloseableHttpResponse response = null;
            try {
                    ObjectMapper om = new ObjectMapper();
                    HttpPost httpPost = new HttpPost(url);
                    httpPost.addHeader("Connection", "close");
                    /*配置请求头*/
                    httpPost.setHeader(HTTP.CONTENT_TYPE, "application/json");
                    /*一行一行读取srcpath文件 并写入请求体中*/
                    httpPost.setEntity(new StringEntity(om.writeValueAsString(JSON.parse(line)),
                            ContentType.create("text/json", "UTF-8")));
                    client = getClient();
                    response = client.execute(httpPost);
                    httpPost.releaseConnection();
//                    client.getConnectionManager().shutdown();
                
            } finally {
                if (response != null) {
                    response.close();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return "aaa";
    }

    public static void pathLog(HttpServletRequest request,HttpSession session,String path,String datetime) {
        String ip;
        if(request!=null){
            ip = request.getHeader("x-forwarded-for");
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        }else{
            int n1 = (int)(68+Math.random()*183);//0--255--->68--250
            int n2 = (int)(23+Math.random()*156);//0--255--->23--178
            int n3 = (int)(Math.random()*256);//0--255
            int n4 = (int)(Math.random()*256);//0--255
            ip = n1+"."+n2+"."+n3+"."+n4;
        }

        String userId = "null";
        String userName = "null";
        if(session==null){
            session = request.getSession();
        }
        if(session!=null){
            User user = (User) session.getAttribute("user");
            if(user!=null){
                userId = user.getId()+"";
                userName = user.getUserName();
            }
        }

        if(datetime==null){
            datetime = TimeUtil.getTime("long");
        }


        //拼串
        String line = "{\"ip\":\""+ip+"\",\"userId\":\""+userId+"\",\"userName\":\""+userName+"\",\"time\":\""+datetime+"\",\"path\":\""+path+"\"}";

        sendLog(line,"userpath");

//        if((int)(Math.random()*5)==4){
//            return;
//        }

        String[] split1 = datetime.split(" ");
        String date = split1[0];
        String time = split1[1];

        String[] strings = time.split(":");
        String hour = strings[0];
        String minute = strings[1];
        String second = strings[2];

        ArrayList<String> arr = new ArrayList<>();
        arr = getPaths(arr);
        ListIterator<String> iterator = arr.listIterator();
        int affordtime = (int) (5 + Math.random() * 55);
        while (iterator.hasNext()){
            String s = iterator.next();
            String[] split = s.split(" ");
            path = split[0];


            int affordminute = affordtime/60;
            int affordsecond = affordtime%60;
            int newminute = Integer.parseInt(minute) + affordminute;
            int newsecond = Integer.parseInt(second) + affordsecond;
            int newhour = Integer.parseInt(hour);
            if(newsecond>=60){
                newminute = newminute + newsecond/60;
                newsecond = newsecond % 60;
            }
            if(newminute>=60){
                newhour = newhour + newminute/60;
                newminute = newminute % 60;
            }
            if(newhour>=24){
                break;
            }
            hour = newhour>=10?""+newhour:"0"+newhour;
            minute = newminute>=10?""+newminute:"0"+newminute;
            second = newsecond>=10?""+newsecond:"0"+newsecond;
            time = ""+hour+":"+minute+":"+second;
            datetime = date+" "+time;


            //拼串
            line = "{\"ip\":\""+ip+"\",\"userId\":\""+userId+"\",\"userName\":\""+userName+"\",\"time\":\""+datetime+"\",\"path\":\""+path+"\"}";

            sendLog(line,"userpath");

            affordtime = Integer.parseInt(split[1]);
        }



    }


    public static ArrayList<String> getPaths(ArrayList<String> list){
        if(list.size()>=6){
            return list;
        }
        int random1 = (int)(Math.random()*2);
        if(random1==1){
            String path = "";
            int random2 = (int)(1+Math.random()*10);
            int random3 = 0;
            if(random2<3){
                path = "/index";
                random3 = (int)(5+Math.random()*55);
            }else if(random2<5){
                path = "/search";
                random3 = (int)(60+Math.random()*240);
            }else if(random2<8){
                path = "/watch";
                random3 = (int)(600+Math.random()*1200);
            }else if(random2<9){
                path = "/login";
                random3 = (int)(10+Math.random()*20);
            }else if(random2<10){
                path = "/register";
                random3 = (int)(120+Math.random()*60);
            }else if(random2<11){
                path = "/home";
                random3 = (int)(5+Math.random()*55);
            }
            String line = path +" "+ random3;
            list.add(line);
            return getPaths(list);
        }
        return list;
    }
}
