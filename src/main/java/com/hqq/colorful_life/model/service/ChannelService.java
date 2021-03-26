package com.hqq.colorful_life.model.service;

import com.hqq.colorful_life.model.domain.Channel;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface ChannelService {


    int deleteByPrimaryKey(Integer id);

    int insert(Channel record);

    int insertSelective(Channel record);

    Channel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Channel record);

    int updateByPrimaryKey(Channel record);

}

