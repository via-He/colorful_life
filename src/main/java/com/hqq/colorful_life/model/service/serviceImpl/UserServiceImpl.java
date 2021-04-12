package com.hqq.colorful_life.model.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.request.UpdateUserReq;
import com.hqq.colorful_life.util.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.dao.UserMapper;
import com.hqq.colorful_life.model.service.UserService;

import java.security.NoSuchAlgorithmException;
import java.util.List;


/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (id == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public void register(String userName, String password) {
        User result = userMapper.selectByName(userName);
        if (result != null) {
            throw new UniteException(ExceptionEnum.NAME_EXISTED);

        }

        //写入数据库
        //新建user
        User user = new User();
        user.setUserName(userName);
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new UniteException(ExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public User login(String userName, String password) {

        String md5Password = null;
        try {
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = userMapper.selectLogin(userName, md5Password);
        if (user == null) {
            throw new UniteException(ExceptionEnum.WRONG_PASSWORD);
        }
        return user;
    }

    @Override
    public PageInfo selectUserList(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<User> users = userMapper.selectAllUser();
        PageInfo<User> userPageInfo = new PageInfo<>(users);
        return userPageInfo;
    }

    @Override
    public void update(User user) {

        log.info("当前修改的用户信息" + user);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public List<User> findUserOrderBySignNum() {

        List<User> users = userMapper.selectAllUser();
        return users;
    }

}


