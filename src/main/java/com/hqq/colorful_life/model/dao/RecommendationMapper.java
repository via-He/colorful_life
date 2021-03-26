package com.hqq.colorful_life.model.dao;

import com.hqq.colorful_life.model.domain.Recommendation;


/**
 * @author Qingqing.He
 * @date 2021/3/17 17:36
 */
public interface RecommendationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Recommendation record);

    int insertSelective(Recommendation record);

    Recommendation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Recommendation record);

    int updateByPrimaryKey(Recommendation record);
}