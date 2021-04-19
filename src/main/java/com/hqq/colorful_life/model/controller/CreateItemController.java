package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.request.AddCreateItemReq;
import com.hqq.colorful_life.model.service.CreateItemService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author Qingqing.He
 * @date 2021/3/22 15:01
 */
@RestController
@RequestMapping("/create")
public class CreateItemController {

    @Resource
    CreateItemService createItemService;

    @PostMapping("/add")
    public ApiRestResponse addCreateItem(@Valid @RequestBody AddCreateItemReq addCreateItemReq){
        Integer userId = UserFilter.currentUser.getId();
        addCreateItemReq.setUserId(userId);
        createItemService.create(addCreateItemReq);
        return ApiRestResponse.success();
    }

    @ApiModelProperty("用户分页查看瞬间内容")
    @GetMapping("/listAll")
    public ApiRestResponse listAll(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
         PageInfo pageInfo = createItemService.listAll(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);

    }

    @GetMapping("/delete")
    public ApiRestResponse delete(@RequestParam Integer createItemId){
        createItemService.deleteByPrimaryKey(createItemId);
        return ApiRestResponse.success();
    }

    @GetMapping("/pink")
    public ApiRestResponse pink(@RequestParam Integer createItemId){
        createItemService.addPink(createItemId);
        return ApiRestResponse.success();
    }

    @PostMapping("/comment")
    public ApiRestResponse comment(@RequestParam Integer createItemId,@RequestParam String comment){
        int i = createItemService.addComment(createItemId, comment);
        return ApiRestResponse.success(i);
    }
}
