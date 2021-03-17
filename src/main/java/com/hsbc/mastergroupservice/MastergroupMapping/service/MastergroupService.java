package com.hsbc.mastergroupservice.MastergroupMapping.service;
import java.util.List;

//import org.springframework.stereotype.Service;

import com.hsbc.mastergroupservice.MastergroupMapping.bean.MastergroupBean;

public interface MastergroupService {
public List<MastergroupBean> readcsvfile(String file);
public String csvtojson();
}
