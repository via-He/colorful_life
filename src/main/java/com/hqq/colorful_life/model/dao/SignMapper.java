package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Sign;


/**
 * @author Qingqing.He
 * @date 2021/3/23 17:42
 */
public interface SignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);
}