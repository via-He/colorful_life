package com.hqq.colorful_life.model.service;

import com.hqq.colorful_life.model.domain.Comment;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface CommentService {


    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> detail(Integer signId, Integer createItemId);

    List<String> momentDetail(Integer createItemId);

    List<String> signDetail(Integer signId);

    Integer commentNum(Integer signId, Integer createItemId);
}

