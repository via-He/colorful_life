package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.domain.CreateItem;
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
import java.util.Date;
import java.util.List;

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
    public ApiRestResponse addCreateItem(@RequestParam String content,@RequestParam String channelName){
        CreateItem addCreateItemReq = new CreateItem();
        Integer userId = UserFilter.currentUser.getId();
        addCreateItemReq.setUserId(userId);
        addCreateItemReq.setContent(content);
        addCreateItemReq.setChannelName(channelName);
        addCreateItemReq.setMediaUrl(FunctionController.getUri);
        createItemService.create(addCreateItemReq);
        return ApiRestResponse.success();
    }

    @ApiModelProperty("用户分页查看瞬间内容")
    @GetMapping("/listAll")
    public ApiRestResponse listAll(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
         PageInfo pageInfo = createItemService.listAll(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);

    }

    @ApiModelProperty("查看指定用户的最新十条瞬间内容")
    @GetMapping("/listByUserId")
    public ApiRestResponse listByUserId(Integer userId){
        List<CreateItem> createItems = createItemService.selectByUserId(userId);
        return ApiRestResponse.success(createItems);

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

    @GetMapping("/comment")
    public ApiRestResponse comment(@RequestParam Integer createItemId,@RequestParam String content){
        int i = createItemService.addComment(createItemId, content);
        return ApiRestResponse.success(i);
    }
}
