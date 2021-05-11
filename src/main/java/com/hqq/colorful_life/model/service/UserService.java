package com.hqq.colorful_life.model.service;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.request.UpdateUserReq;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface UserService {


    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void register(String userName, String password);

    User login(String userName, String password);

    PageInfo selectUserList(Integer pageNum, Integer pageSize);

    void update(User user);

    PageInfo findUserOrderBySignNum(Integer pageNum, Integer pageSize);

    PageInfo selectListByKeyword(Integer pageNum, Integer pageSize, String keyWord);
}


