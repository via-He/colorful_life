package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.CreateItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;


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

    List<CreateItem> listAll(Integer id);

    List<CreateItem> selectByChannelName(String channelName);

    List<CreateItem> listAllForAdmin();

    List<CreateItem> selectListByKeyword(@Param("keyword") String keyword);
}