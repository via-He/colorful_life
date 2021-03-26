package com.hqq.colorful_life.model.service;

import com.hqq.colorful_life.model.domain.Pink;
    
/**
*@author Qingqing.He
*@date 2021/3/16 10:46
*/
public interface PinkService{


    int deleteByPrimaryKey(Integer id);

    int insert(Pink record);

    int insertSelective(Pink record);

    Pink selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Pink record);

    int updateByPrimaryKey(Pink record);

}
