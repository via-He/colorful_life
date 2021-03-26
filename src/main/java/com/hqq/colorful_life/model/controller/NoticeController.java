package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.model.domain.Notice;
import com.hqq.colorful_life.model.service.NoticeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author Qingqing.He
 * @date 2021/3/19 17:28
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Resource
    NoticeService noticeService;

    @GetMapping("/list")
    public ApiRestResponse list(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo list = noticeService.list(pageNum, pageSize);
        return ApiRestResponse.success(list);
    }

    @PostMapping("/admin/addNotice")
    public ApiRestResponse addNotice(@RequestParam String comment){

        noticeService.insertSelective(comment);
        return ApiRestResponse.success();
    }

    @PostMapping("/admin/update")
    public ApiRestResponse update(@RequestParam String content,@RequestParam Integer noticeId){
        Notice notice = noticeService.selectByPrimaryKey(noticeId);
        if (content.isEmpty()) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        notice.setContent(content);
        noticeService.updateByPrimaryKeySelective(notice);
        return ApiRestResponse.success();
    }

    @GetMapping("/delete")
    public ApiRestResponse delete(@RequestParam Integer noticeId){
        int i = noticeService.deleteByPrimaryKey(noticeId);
        return ApiRestResponse.success(i);
    }
}
