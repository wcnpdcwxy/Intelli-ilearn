package com.edu360.ilearn.service;

import com.edu360.ilearn.entity.bounceRate;
import com.edu360.ilearn.entity.pNum;
import com.edu360.ilearn.entity.pathTable;

import java.util.ArrayList;

public interface DataService {

    ArrayList<pNum> getPnum();

    ArrayList<bounceRate> getBounceRate();

    ArrayList<pathTable> getPathTable(String date);
}
