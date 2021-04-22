package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Comment;
import com.hqq.colorful_life.model.domain.CreateItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author Qingqing.He
 * @date 2021/3/23 10:45
 */
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<String> ItemDetail(@Param("createItemId") Integer createItemId);

    List<String> SignDetail(@Param("signId") Integer signId);
}