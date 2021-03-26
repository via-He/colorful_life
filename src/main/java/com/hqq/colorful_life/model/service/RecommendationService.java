package com.hqq.colorful_life.model.service;

import com.hqq.colorful_life.model.domain.Recommendation;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface RecommendationService {


    int deleteByPrimaryKey(Integer id);

    int insert(Recommendation record);

    int insertSelective(Recommendation record);

    Recommendation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recommendation record);

    int updateByPrimaryKey(Recommendation record);

}


