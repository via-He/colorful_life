package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.domain.Sign;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.service.SignService;
import com.hqq.colorful_life.model.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Qingqing.He
 * @date 2021/3/23 14:05
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/sign",method = RequestMethod.POST)
public class SignController {
    @Resource
    SignService signService;

    @Resource
    UserService userService;

    @Resource
    FunctionController functionController;

    @ApiOperation("签到")
    @PostMapping("/signIn")
    public ApiRestResponse signIn(@RequestParam String content,@RequestParam String channelName,
                                  @RequestParam String title){
        Sign sign = new Sign();

        sign.setUserId(UserFilter.currentUser.getId());
        sign.setMediaUrl(FunctionController.getUri);
        sign.setChannelName(channelName);
        sign.setContent(content);
        sign.setTitle(title);
        int i = signService.insertSelective(sign);
        //签到成功，签到次数加一
        if (i == 1){
            User user = UserFilter.currentUser;
            Integer signNum = user.getSignNum();
            signNum++;
            user.setSignNum(signNum);
            userService.updateByPrimaryKeySelective(user);
        }
        return ApiRestResponse.success();

    }

    @ApiOperation("根据当前用户id查看所有签到")
    @GetMapping("/listSign")
    public ApiRestResponse listSign(@RequestParam Integer pageNum, @RequestParam Integer pageSize){

        PageInfo pageInfo = signService.selectSignList(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("根据id查看签到详情")
    @GetMapping("/byId")
    public ApiRestResponse selectById(@RequestParam Integer signId){

        Sign sign = signService.selectByPrimaryKey(signId);
        return ApiRestResponse.success(sign);
    }

    @ApiOperation("查询个人签到次数")
    @GetMapping("/signNum")
    public ApiRestResponse selectSignNum(){

        Integer userId = UserFilter.currentUser.getId();
        Integer signNum = signService.selectSignNum(userId);
        return ApiRestResponse.success(signNum);
    }

    @ApiOperation("删除签到")
    @GetMapping("/delete")
    public ApiRestResponse delete(@RequestParam Integer signId){

        int i = signService.deleteByPrimaryKey(signId);
        return ApiRestResponse.success(i);
    }

    @PostMapping("/comment")
    public ApiRestResponse comment(@RequestParam Integer signId,@RequestParam String comment){
        int i = signService.addComment(signId, comment);
        return ApiRestResponse.success(i);
    }
}
