package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.User;import org.apache.ibatis.annotations.Param;import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String userName);

    User selectLogin(@Param("userName") String userName, @Param("password") String md5Password);

    List<User> selectAllUser();
}