package com.hqq.colorful_life.model.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.domain.Recommendation;
import com.hqq.colorful_life.model.dao.RecommendationMapper;
import com.hqq.colorful_life.model.service.RecommendationService;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Resource
    private RecommendationMapper recommendationMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return recommendationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Recommendation record) {
        return recommendationMapper.insert(record);
    }

    @Override
    public int insertSelective(Recommendation record) {
        return recommendationMapper.insertSelective(record);
    }

    @Override
    public Recommendation selectByPrimaryKey(Integer id) {
        return recommendationMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Recommendation record) {
        return recommendationMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Recommendation record) {
        return recommendationMapper.updateByPrimaryKey(record);
    }

}


