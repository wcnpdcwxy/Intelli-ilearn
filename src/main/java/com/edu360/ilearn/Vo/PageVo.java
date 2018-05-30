package com.edu360.ilearn.Vo;

import com.edu360.ilearn.Tool.PageHelper;
import com.edu360.ilearn.entity.Course;

import java.util.Arrays;
import java.util.List;

public class PageVo <T>{
    private List<T> totalList;
    private List<T> pageList;
    private int total_page_num = 0;
    private int[] start_end;
    private int now_page = 1;
    private int show_page_Num = 4;
    private int total_data_num = 0;
    private int page_data_num = 16;

    public List<T> getTotalList() {
        return totalList;
    }

    public void setTotalList(List<T> totalList) {
        this.totalList = totalList;
        setPageList();
    }

    public List<T> getPageList() {
        return pageList;
    }

    private void setPageList() {
        if(totalList!=null){
            pageList = PageHelper.trunList(totalList,now_page,page_data_num);
        }
    }

    public int getTotal_page_num() {
        return total_page_num;
    }

    private void setTotal_page_num() {
        total_page_num = PageHelper.totalPage(total_data_num,page_data_num);
        setStart_end();
    }

    public int[] getStart_end() {
        return start_end;
    }

    private void setStart_end() {
        if(total_page_num!=0){
            start_end = PageHelper.getShowPageNum(total_page_num,now_page,show_page_Num);
        }
    }

    public int getNow_page() {
        return now_page;
    }

    public void setNow_page(int now_page) {
        this.now_page = now_page;
        setStart_end();
        setPageList();
    }

    public int getShow_page_Num() {
        return show_page_Num;
    }

    public void setShow_page_Num(int show_page_Num) {
        this.show_page_Num = show_page_Num;
        setStart_end();
    }

    public int getTotal_data_num() {
        return total_data_num;
    }

    public void setTotal_data_num(int total_data_num) {
        this.total_data_num = total_data_num;
        setTotal_page_num();
    }

    public int getPage_data_num() {
        return page_data_num;
    }

    public void setPage_data_num(int page_data_num) {
        this.page_data_num = page_data_num;
        setTotal_page_num();
        setPageList();
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "totalList=" + totalList +
                ", pageList=" + pageList +
                ", total_page_num=" + total_page_num +
                ", start_end=" + Arrays.toString(start_end) +
                ", now_page=" + now_page +
                ", show_page_Num=" + show_page_Num +
                ", total_data_num=" + total_data_num +
                ", page_data_num=" + page_data_num +
                '}';
    }
}
