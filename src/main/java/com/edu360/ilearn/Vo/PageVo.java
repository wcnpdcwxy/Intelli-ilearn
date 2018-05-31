package com.edu360.ilearn.Vo;

import com.edu360.ilearn.Tool.PageHelper;
import com.edu360.ilearn.entity.Course;

import javax.xml.transform.Source;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

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



    public void setPage_data_time_order(String page_data_time_order) {
        List<T> pageList1 = getTotalList();
        List<Course> pageList2 = null;
//        if(((Course)pageList1.get(1)).getCourseName()!=null){
            pageList2 = (List<Course>) pageList1;

            Comparator<Course> comparator= new Comparator<Course>(){
                public int compare(Course s1, Course s2) {
                    if(s1.getTime()!=s2.getTime()){
                        return s2.getTime().compareTo(s1.getTime());
                    }else{
                        return s2.getId()-s1.getId();
                    }
                }
            };

            Comparator<Course> comparator2= new Comparator<Course>(){
                public int compare(Course s1, Course s2) {
                    if(s1.getTime()!=s2.getTime()){
                        return s1.getTime().compareTo(s2.getTime());
                    }else{
                        return s2.getId()-s1.getId();
                    }
                }
            };

            if(page_data_time_order.equals("down")){
                pageList2.sort(comparator);
            }else{
                pageList2.sort(comparator2);
            }



        setTotalList((List<T>)pageList2);

//            System.out.println(pageList);
//        }

    }

    private List<T> oldTotalList;

    public List<T> getOldTotalList() {
        return oldTotalList;
    }

    public void setOldTotalList() {
        this.oldTotalList = totalList;
    }

    public void setPage_data_time_filter(int page_data_time_filter) {
        List<T> pageList1 = getOldTotalList();
        List<Course> pageList2 = null;
//        if(((Course)pageList1.get(1)).getCourseName()!=null){
            pageList2 = (List<Course>) pageList1;

            long nowTime = new Date().getTime();

            List<Course> pageList3 = new ArrayList<Course>();

            for(int i = 0;i<pageList2.size();i++){
                Course course = pageList2.get(i);

                String timestr = course.getTime();
                Date thistime = new SimpleDateFormat("yyyy-MM-dd").parse(timestr, new ParsePosition(0));

                long time = thistime.getTime();
                long millis = nowTime - time;

                long days = TimeUnit.MILLISECONDS.toDays(millis);

                if(days<page_data_time_filter){
                    pageList3.add(course);
                }

            }


        setTotalList((List<T>)pageList3);

//            System.out.println(pageList);
        }

//    }
}
