package com.edu360.ilearn.Tool;

import java.util.List;

public class PageHelper {
    // 拿到第几页多少条数据
    public static List trunList(List list, int page, int pnum) {

//        测试
//        if(list==null){
//            System.out.println("1.list is null");
//        }


        int start = (page - 1) * pnum;
        int end = start + pnum;
        return trunListByStart(list,start,end);
    }

    // 取出自定义条数记录的list
    private static List trunListByStart(List list, int start, int end) {
        if (list == null){
//            System.out.println("2.list is null");
            return null;
        }else if (list.size() > end){
            return list.subList(start, end);
        }else if (list.size() > start){
            return list.subList(start, list.size());
        }else{
            return list;
        }
    }

    //总页数
    public static int totalPage(int total,int pnum){
        if(total<pnum){
            return 1;
        }
        else{
            return (total / pnum + (total % pnum == 0 ? 0 : 1));
        }
    }

    //分页 页码
    public static int[] getShowPageNum(int totalpage,int pageNo,int showNum){

        int[]se=new int[2];

        se[0]=0;se[1]=0;

        if(totalpage>0&&pageNo>0){
            int tmpNum=pageNo-showNum/2;
            int start=1+tmpNum;
            int end=showNum+tmpNum;

            if(start< 1){
                end=end+(1-start);
                start=1;
                if(end>totalpage){
                    end=totalpage;
                }
            }
            if(end>totalpage){
                start=start-(end-totalpage);
                end=totalpage;
                if(start< 1){
                    start=1;
                }
            }
            se[0]=start;
            se[1]=end;
        }
        return se;
    }
}
