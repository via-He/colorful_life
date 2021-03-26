package com.hqq.colorful_life.model.service;

import com.hqq.colorful_life.model.domain.Info;
    
/**
*@author Qingqing.He
*@date 2021/3/17 17:11
*/
public interface InfoService{


    int deleteByPrimaryKey(Integer id);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);

}
