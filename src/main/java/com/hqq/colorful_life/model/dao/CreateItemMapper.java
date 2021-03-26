package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.CreateItem;


/**
 * @author Qingqing.He
 * @date 2021/3/22 15:05
 */
public interface CreateItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreateItem record);

    int insertSelective(CreateItem record);

    CreateItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreateItem record);

    int updateByPrimaryKey(CreateItem record);
}