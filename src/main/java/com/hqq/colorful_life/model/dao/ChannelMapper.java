package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Channel;


/**
 * @author Qingqing.He
 * @date 2021/3/17 17:11
 */
public interface ChannelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);
}