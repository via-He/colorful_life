package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Comment;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<String> ItemDetail(@Param("createItemId") Integer createItemId);

    List<String> SignDetail(@Param("signId") Integer signId);

    List<Comment> detail(@Param("signId") Integer signId, @Param("createItemId") Integer createItemId);

    Integer selectCommentNum(@Param("signId") Integer signId, @Param("createItemId") Integer createItemId);
}