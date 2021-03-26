package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Notice;import java.util.List;


/**
 * @author Qingqing.He
 * @date 2021/3/22 15:06
 */
public interface NoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);

    List<Notice> selectAllNotice();
}