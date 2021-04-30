package com.hqq.colorful_life.model.controller;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.common.ApiRestResponse;
import com.hqq.colorful_life.filter.AdminFilter;
import com.hqq.colorful_life.model.domain.Recommendation;
import com.hqq.colorful_life.model.service.RecommendationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/reco")
public class RecommendationController {


    @Resource
    RecommendationService recommendationService;

    @PostMapping("/admin/add")
    public ApiRestResponse addReco(@RequestParam Integer createItemId){
        Recommendation recommendation = new Recommendation();
        Integer userId = AdminFilter.currentSysUser.getId();
        recommendation.setSysUserId(userId);
        recommendation.setCreateId(createItemId);
        recommendationService.insert(recommendation);
        return ApiRestResponse.success();

    }

    @GetMapping("/admin/delete")
    public ApiRestResponse delete(@RequestParam Integer id){
        recommendationService.deleteByPrimaryKey(id);
        return ApiRestResponse.success();
    }


    @GetMapping("/listAll")
    public ApiRestResponse listAll(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        PageInfo pageInfo = recommendationService.selectListAll(pageNum,pageSize);
        return ApiRestResponse.success(pageInfo);
    }
}
