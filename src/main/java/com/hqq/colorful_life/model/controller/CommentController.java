package com.hqq.colorful_life.model.controller;

import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.model.domain.Comment;
import com.hqq.colorful_life.model.service.CommentService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/23 13:49
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Resource
    CommentService commentService;

    @ApiOperation("前台查看瞬间评论")
    @PostMapping("/itemDetail")
    public ApiRestResponse itemDetail(@RequestParam Integer createItemId){
        List<String> content = commentService.momentDetail(createItemId);
        return ApiRestResponse.success(content);
    }

    @ApiOperation("前台查看签到评论")
    @PostMapping("/signDetail")
    public ApiRestResponse SignDetail(@RequestParam Integer signId){
        List<String> content = commentService.signDetail(signId);
        return ApiRestResponse.success(content);
    }

    @ApiOperation("查看动态评论")
    @PostMapping("/detail")
    public ApiRestResponse detail(@RequestParam(required = false) Integer signId,@RequestParam(required = false) Integer createItemId){
        List<Comment> content = commentService.detail(signId,createItemId);
        return ApiRestResponse.success(content);
    }

    @ApiOperation("查看评论数量")
    @PostMapping("/commentNum")
    public ApiRestResponse commentNum(@RequestParam(required = false) Integer signId,@RequestParam(required = false) Integer createItemId){
        Integer commentNum = commentService.commentNum(signId,createItemId);
        return ApiRestResponse.success(commentNum);
    }



    @ApiOperation("删除评论")
    @PostMapping("/delete")
    public ApiRestResponse delete(@RequestParam Integer commentId){
        int i = commentService.deleteByPrimaryKey(commentId);
        return ApiRestResponse.success(i);
    }



}
