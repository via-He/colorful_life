package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.common.Constant;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.domain.SysUser;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.model.request.UpdateUserReq;
import com.hqq.colorful_life.model.service.SysUserService;
import com.hqq.colorful_life.model.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author Qingqing.He
 * @date 2021/3/16 11:18
 */

@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @Resource
    SysUserService sysUserService;

    @ApiOperation("查询指定id的用户")
    @GetMapping("/admin/byId")
    public ApiRestResponse personalPage(@RequestParam Integer userId,HttpSession session){
        Object attribute = session.getAttribute(Constant.USER);
        if (attribute == null)
        {
            throw new UniteException(ExceptionEnum.NEED_LOGIN);
        }
        if (attribute instanceof User){
            throw new UniteException(ExceptionEnum.NEED_ADMIN);
        }

        User user = userService.selectByPrimaryKey(userId);
        log.info("session里是否存在值"+ UserFilter.currentUser);
        return ApiRestResponse.success(user);
    }

    @ApiOperation("分页查询所有用户")
    @GetMapping("/admin/allUser")
    public ApiRestResponse personalPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        PageInfo pageInfo = userService.selectUserList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    /**
     * 注册新用户
     * @param userName
     * @param password
     * @return
     * @throws Exception
     */
    @ApiOperation("注册新用户")
    @PostMapping("/register")
    public ApiRestResponse register(@RequestParam("userName") String userName,
                                    @RequestParam("password") String password ) throws UniteException {
        if (StringUtils.isEmpty(userName)){
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)){
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }

        if (password.length() < 8){
            return ApiRestResponse.error(ExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(userName,password);

        return ApiRestResponse.success();

    }

    /**
     * 普通人员登录
     * @param userName
     * @param password
     * @param session
     * @return
     * @throws UniteException
     */
    @ApiOperation("普通人员登录")
    @PostMapping("/login")
    public ApiRestResponse login(@RequestParam("userName")String userName,
                                 @RequestParam("password")String password, HttpSession session) throws UniteException {

        if (StringUtils.isEmpty(userName)){
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)){
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }

        User user = userService.login(userName,password);
        //为了安全性，将密码设置为空 即返回user时密码为空

        user.setPassword(null);
        session.setAttribute(Constant.USER, user);
        session.setMaxInactiveInterval(60*60);//过期时间一小时
        log.info(session.getAttribute(Constant.USER)+"hffffffff");
        return ApiRestResponse.success(user);
    }

    /**
     * 登出，清除session
     * @param session
     * @return
     */
    @ApiOperation("登出，清除session")
    @PostMapping("/logout")
    public ApiRestResponse logout(HttpSession session){
        session.removeAttribute(Constant.USER);
        log.info("退出后查看session"+session.getAttribute(Constant.USER));
        return ApiRestResponse.success();
    }

    /**
     * 管理员登录
     * @param userName
     * @param password
     * @param session
     * @return
     * @throws UniteException
     */
    @ApiOperation("管理员登录")
    @PostMapping("/adminLogin")
    public ApiRestResponse adminLogin(@RequestParam("userName")String userName,
                                      @RequestParam("password")String password, HttpSession session) throws UniteException {

        if (StringUtils.isEmpty(userName)){
            return ApiRestResponse.error(ExceptionEnum.NEED_USER_NAME);
        }
        if (StringUtils.isEmpty(password)){
            return ApiRestResponse.error(ExceptionEnum.NEED_PASSWORD);
        }

        SysUser sysUser = sysUserService.login(userName, password);
        sysUser.setPassword(null);
        session.setAttribute(Constant.USER, sysUser);
        log.info("当前正在登录的管理员用户："+ session.getAttribute(Constant.USER));
        return ApiRestResponse.success(sysUser);

    }

    /**
     * 更新个人资料
     * @param updateUserReq
     * @param session
     * @return
     */
    @ApiOperation("更新个人资料")
    @PostMapping("/update")
    public ApiRestResponse update(@RequestBody UpdateUserReq updateUserReq,HttpSession session){
        User user = (User)session.getAttribute(Constant.USER);
        BeanUtils.copyProperties(updateUserReq,user);
        userService.update(user);
        return ApiRestResponse.success();
    }

    /**
     * 删除指定用户
     * @param userId
     * @return
     */
    @ApiOperation("删除指定用户")
    @GetMapping("/admin/delete")
    public ApiRestResponse delete(@RequestParam Integer userId){
        int i = userService.deleteByPrimaryKey(userId);
        return ApiRestResponse.success(i);
    }



}
