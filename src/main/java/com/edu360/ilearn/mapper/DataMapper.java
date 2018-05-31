package com.edu360.ilearn.mapper;

import com.edu360.ilearn.entity.User;
import com.edu360.ilearn.entity.bounceRate;
import com.edu360.ilearn.entity.pNum;
import com.edu360.ilearn.entity.pathTable;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface DataMapper {

    ArrayList<pNum> getPnum();

    ArrayList<bounceRate> getBounceRate();

    ArrayList<pathTable> getPathTable(String date);

}
