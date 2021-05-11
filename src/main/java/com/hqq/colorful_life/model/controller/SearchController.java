package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.model.service.CreateItemService;
import com.hqq.colorful_life.model.service.SignService;
import com.hqq.colorful_life.model.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SearchController {

    @Resource
    SignService signService;

    @Resource
    CreateItemService createItemService;

    @Resource
    UserService userService;

    @ApiOperation("搜索签到")
    @GetMapping("/searchSign")
    public ApiRestResponse searchSign(@RequestParam Integer pageNum, @RequestParam Integer pageSize, String keyword){

        PageInfo pageInfo = signService.selectListByKeyword(pageNum,pageSize,keyword);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("搜索瞬间")
    @GetMapping("/searchMoment")
    public ApiRestResponse searchMoment(@RequestParam Integer pageNum, @RequestParam Integer pageSize, String keyword){

        PageInfo pageInfo = createItemService.selectListByKeyword(pageNum,pageSize,keyword);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("搜索用户")
    @GetMapping("/searchUser")
    public ApiRestResponse searchUser(@RequestParam Integer pageNum, @RequestParam Integer pageSize, String keyword){

        PageInfo pageInfo = userService.selectListByKeyword(pageNum,pageSize,keyword);
        return ApiRestResponse.success(pageInfo);
    }
}
