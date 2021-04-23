package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.model.service.CreateItemService;
import com.hqq.colorful_life.model.service.SignService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    CreateItemService createItemService;

    @Resource
    SignService signService;

    @ApiModelProperty("后台查看所有瞬间内容")
    @GetMapping("/listAllForAdmin")
    public ApiRestResponse listAllForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        PageInfo pageInfo = createItemService.listAllForAdmin(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);

    }


    @ApiModelProperty("后台查看所有签到内容")
    @GetMapping("/listSignForAdmin")
    public ApiRestResponse listSignForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
        PageInfo pageInfo = signService.listSignForAdmin(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);

    }
}
