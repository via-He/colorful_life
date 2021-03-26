package com.hqq.colorful_life.model.service;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.model.domain.Notice;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface NoticeService {


    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    void insertSelective(String record);

    Notice selectByPrimaryKey(Integer id);

    void updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    PageInfo list(Integer pageNum, Integer pageSize);
}

