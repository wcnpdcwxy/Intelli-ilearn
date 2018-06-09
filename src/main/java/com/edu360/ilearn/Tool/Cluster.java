package com.edu360.ilearn.Tool;

import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.*;
import weka.core.converters.DatabaseLoader;

import java.util.ArrayList;

public class Cluster {
    public static ArrayList getList(){
        SimpleKMeans KM = null;
        ArrayList lists = new ArrayList();

        try {
            /**
             * 读取mysql作为数据源
             */
            DatabaseLoader dloader = new DatabaseLoader();
            DatabaseLoader dloader2 = new DatabaseLoader();
            String jdurl="jdbc:mysql://127.0.0.1:3306/istudy";
            String user = "root";
            String pass = "123456";
            dloader.setSource(jdurl,user,pass);
            dloader2.setSource(jdurl,user,pass);
            //user_id,nick_name,
            dloader.setQuery("SELECT fav_num,ord_num,his_num FROM pre_data");
            //批量检索
            Instances inst = dloader.getDataSet();

            dloader2.setQuery("SELECT user_id,fav_num,ord_num,his_num FROM pre_data");
            //批量检索
            Instances inst2 = dloader2.getDataSet();

            // 初始化聚类器 （加载算法）
            KM = new SimpleKMeans();
            KM.setNumClusters(4);       //设置聚类要得到的类别数量
            KM.setSeed(2500);
            KM.buildClusterer(inst);     //开始进行聚类

//          System.out.println(KM.preserveInstancesOrderTipText());

            //簇信息
//            Instances instances = KM.getClusterCentroids();
//            System.out.println("Centroids:" + instances);
//            System.out.println("*********************");

            //数据源信息

/*            ArrayList lists = new ArrayList();
            //遍历所有的instances
            for (int i = 0; i < instances.numInstances(); i++) {
                ArrayList list = new ArrayList();
                //获取到当前索引处的instance
                Instance instance = instances.get(i);
                System.out.println(instances.numAttributes());

                //遍历instances中的instance
                for (int j = 0; j < instance.numAttributes(); j++) {
//                    每一簇的值
//                    System.out.println(instance.value(j) + ",");
                    list.add(instance.value(j));
                    System.out.println(list);
                }

                //将instances中的每个instance添加到集合中
                lists.add(list);
            }
            System.out.println(lists);*/

            // 打印聚类结果
//            System.out.println(KM.toString());

//            System.out.println("*********************");
            //每个instance所对应的簇
            for (int i = 0; i < inst2.numInstances(); i++) {
                Instance instance = inst2.get(i);

                int cluster = KM.clusterInstance(inst.instance(i));

                String res = (cluster+1) +":"+ instance.toString();
                lists.add(res);
            }


//            System.out.println("*****************************************************************");

            //评估
            ClusterEvaluation eval = new ClusterEvaluation();
            eval.setClusterer(KM);
            eval.evaluateClusterer(inst);
            String test_res = eval.clusterResultsToString();

            String clustered_instances = test_res.split("Clustered Instances")[1];
            String[] split = clustered_instances.split("%");

            for(int i = 0;i<split.length-1;i++){
                String s = split[i];
                lists.add((i+1)+","+s.substring(s.length()-2,s.length()));
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return lists;
    }
}
