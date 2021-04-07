package com.hqq.colorful_life.model.service;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.model.domain.Sign;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface SignService {


    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

    int addComment(Integer signId, String comment);

    PageInfo selectSignList(Integer pageNum, Integer pageSize);

    Integer selectSignNum(Integer userId);
}



