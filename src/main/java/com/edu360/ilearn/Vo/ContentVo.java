package com.edu360.ilearn.Vo;

import com.edu360.ilearn.entity.Content;
import com.edu360.ilearn.entity.Discuss;

import java.util.ArrayList;

public class ContentVo {
    private Content content;
    //    视频评论列表
    private ArrayList<Discuss> list;

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public ArrayList<Discuss> getList() {
        return list;
    }

    public void setList(ArrayList<Discuss> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ContentVo{" +
                "content=" + content +
                ", list=" + list +
                '}';
    }
}
