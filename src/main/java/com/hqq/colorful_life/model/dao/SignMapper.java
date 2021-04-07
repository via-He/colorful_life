package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Sign;import java.util.List;


/**
 * @author Qingqing.He
 * @date 2021/4/6 13:38
 */
public interface SignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

    List<Sign> selectAllSign(Integer userId);

    Integer selectSignNum(Integer userId);
}