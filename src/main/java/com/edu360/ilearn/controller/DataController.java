package com.edu360.ilearn.controller;

import com.edu360.ilearn.Tool.Cluster;
import com.edu360.ilearn.Vo.PageVo;
import com.edu360.ilearn.Vo.PieVo;
import com.edu360.ilearn.entity.bounceRate;
import com.edu360.ilearn.entity.pNum;
import com.edu360.ilearn.entity.pathTable;
import com.edu360.ilearn.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DataController {

    @Autowired
    private DataService dataService;


    //获取pnum信息
    @PostMapping("/getPnum")
    @ResponseBody
    public List<pNum> getPnum(){

        ArrayList<pNum> list = dataService.getPnum();
        pNum pNum1 = list.get(0);

        //寻找最后一个值得坐标
        int count = 0;
        ArrayList<Integer> arr = pNum1.toArr();
        for(int i = 0;i< arr.size();i++){
            if(arr.get(i)==0){
                count = i-1;
                break;
            }
        }
        //截出有值得部分
        List<pNum> newList = list.subList(0, count+1);
        int[] ints;
        //处理data数据
        for(int i = 0;i< newList.size();i++){
            ints = new int[newList.size()];
            pNum pNum = newList.get(i);
            ArrayList<Integer> arr2 = pNum.toArr();
            for(int y = 0;y<i;y++){
                ints[y]=0;
            }
            for(int y = 0;y<newList.size()-i;y++){
                ints[y+i] = arr2.get(y);
            }
            pNum.setInts(ints);
            newList.set(i,pNum);

        }
        return newList;
    }

    //获取pnum信息
    @PostMapping("/getBounceRate")
    @ResponseBody
    public ArrayList<bounceRate> getBounceRate(){
        ArrayList<bounceRate> list = dataService.getBounceRate();
        System.out.println(list);
        return list;
    }

    @PostMapping("/getPie")
    @ResponseBody
    public ArrayList<PieVo> getPie(HttpSession session){
        ArrayList clusterList = (ArrayList) session.getAttribute("clusterList");
        if(clusterList==null){
            clusterList = Cluster.getList();
            session.setAttribute("clusterList",clusterList);
        }

        ArrayList list = clusterList;
        List sublist = list.subList(list.size() - 4, list.size());

        ArrayList<PieVo> pieList = new ArrayList<>();
        for(int i = 0;i<sublist.size();i++){
            String s = sublist.get(i).toString();
            String[] split = s.split(",");

            String type = split[0];
            if(type.equals("1")){
                type="忠实的学习者";
            }else if(type.equals("2")){
                type="心动没有行动的浪子";
            }else if(type.equals("3")){
                type="缺乏耐心的学习者";
            }else if(type.equals("4")){
                type="有规划的自学者";
            }
            int rate = Integer.parseInt(split[1]);

            PieVo pieVo = new PieVo();
            pieVo.setType(type);
            pieVo.setRate(rate);
            pieList.add(pieVo);
        }
        System.out.println("pieList"+pieList);
        return pieList;
    }

    //获取pnum信息
    @GetMapping("/getPathTable")
    public String getPathTable(Integer pageNum, HttpSession session){
        session.removeAttribute("PathTablepVo");

        ArrayList<pathTable> list = dataService.getPathTable("05_06");
        PageVo pVo = new PageVo();
        if(list!=null){
            pVo.setTotalList(list);
            pVo.setTotal_data_num(list.size());
            pVo.setPage_data_num(9);
            pVo.setShow_page_Num(7);

        }
        session.setAttribute("PathTablepVo",pVo);

        return "redirect:toTable";
    }

    @GetMapping("/getCluster")
    public String getCluster(Integer pageNum, HttpSession session){
        session.removeAttribute("ClusterpVo");

        ArrayList clusterList = (ArrayList) session.getAttribute("clusterList");
        if(clusterList==null){
            clusterList = Cluster.getList();
            session.setAttribute("clusterList",clusterList);
        }

        ArrayList list = clusterList;
        List sublist = list.subList(0, list.size() - 4);
        PageVo pVo = new PageVo();
        if(sublist!=null){
            pVo.setTotalList(sublist);
            pVo.setTotal_data_num(sublist.size());
            pVo.setPage_data_num(16);
        }
        session.setAttribute("ClusterpVo",pVo);

        return "redirect:toCluster";
    }
}
