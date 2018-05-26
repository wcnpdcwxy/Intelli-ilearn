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
    }
}
