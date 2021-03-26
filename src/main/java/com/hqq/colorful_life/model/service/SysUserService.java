package com.hqq.colorful_life.model.service;

import com.hqq.colorful_life.model.domain.SysUser;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface SysUserService {


    int deleteByPrimaryKey(Integer id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser login(String userName, String password);
}

