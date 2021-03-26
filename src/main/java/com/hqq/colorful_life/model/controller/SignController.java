package com.hqq.colorful_life.model.controller;

import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.domain.Sign;
import com.hqq.colorful_life.model.service.SignService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Qingqing.He
 * @date 2021/3/23 14:05
 */
@RestController
@RequestMapping("/sign")
public class SignController {
    @Resource
    SignService signService;

    @Resource
    FunctionController functionController;

    @ApiOperation("签到")
    @PostMapping("/signIn")
    public ApiRestResponse signIn(@RequestParam String content,@RequestParam String channelName){
        Sign sign = new Sign();

        sign.setUserId(UserFilter.currentUser.getId());
        sign.setMediaUrl(FunctionController.getUri);
        sign.setChannelName(channelName);
        sign.setContent(content);
        signService.insertSelective(sign);
        return ApiRestResponse.success();

    }


    @PostMapping("/comment")
    public ApiRestResponse comment(@RequestParam Integer signId,@RequestParam String comment){
        int i = signService.addComment(signId, comment);
        return ApiRestResponse.success(i);
    }
}
