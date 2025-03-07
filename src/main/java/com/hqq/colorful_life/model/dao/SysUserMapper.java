package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.SysUser;import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectLogin(@Param("userName") String userName, @Param("password") String md5Password);
}