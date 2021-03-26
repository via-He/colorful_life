package com.hqq.colorful_life.model.service.serviceImpl;

import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.util.MD5Utils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.dao.SysUserMapper;
import com.hqq.colorful_life.model.domain.SysUser;
import com.hqq.colorful_life.model.service.SysUserService;

import java.security.NoSuchAlgorithmException;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Integer id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public SysUser login(String userName, String password) {

        String md5Password = null;
        try {
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        SysUser sysUser = sysUserMapper.selectLogin(userName, md5Password);
        if (sysUser == null) {
            throw new UniteException(ExceptionEnum.WRONG_PASSWORD);
        }
        return sysUser;
    }

}



