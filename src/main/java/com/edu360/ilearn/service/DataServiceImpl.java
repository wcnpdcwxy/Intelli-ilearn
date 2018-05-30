package com.edu360.ilearn.service;

import com.edu360.ilearn.entity.bounceRate;
import com.edu360.ilearn.entity.pNum;
import com.edu360.ilearn.entity.pathTable;
import com.edu360.ilearn.mapper.DataMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;


    @Override
    public ArrayList<pNum> getPnum() {
        ArrayList<pNum> list = dataMapper.getPnum();
        return list;
    }

    @Override
    public ArrayList<bounceRate> getBounceRate() {
        ArrayList<bounceRate> list = dataMapper.getBounceRate();
        return list;
    }

    @Override
    public ArrayList<pathTable> getPathTable(String date) {
        ArrayList<pathTable> list = dataMapper.getPathTable(date);
        return list;
    }

}

