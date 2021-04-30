package com.hqq.colorful_life.model.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.model.dao.CreateItemMapper;
import com.hqq.colorful_life.model.domain.CreateItem;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.domain.Recommendation;
import com.hqq.colorful_life.model.dao.RecommendationMapper;
import com.hqq.colorful_life.model.service.RecommendationService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class RecommendationServiceImpl implements RecommendationService {

    @Resource
    private RecommendationMapper recommendationMapper;

    @Resource
    CreateItemMapper createItemMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (id == null) {
            throw new UniteException(ExceptionEnum.PARAM_NOT_NULL);
        }
        return recommendationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Recommendation record) {
        if (record == null) {
            throw new UniteException(ExceptionEnum.PARAM_NOT_NULL);
        }
        CreateItem createItem = createItemMapper.selectByPrimaryKey(record.getCreateId());
        if (createItem == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
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

    @Override
    public PageInfo selectListAll(Integer pageNum, Integer pageSize) {

        List<Recommendation> recommendations = recommendationMapper.selectListAll();
        ArrayList<CreateItem> createItems = new ArrayList<>();
        for (int i = 0; i < recommendations.size(); i++) {
            Recommendation recommendation = recommendations.get(i);
            CreateItem createItem = createItemMapper.selectByPrimaryKey(recommendation.getCreateId());
            createItems.add(createItem);
        }
        //创建Page类
        Page page = new Page(pageNum, pageSize);
        //为Page类中的total属性赋值
        int total = createItems.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum -1)*pageSize;
        int endIndex = Math.min(startIndex + pageSize,total);
        //从链表中截取需要显示的子链表，并加入到Page
        page.addAll(createItems.subList(startIndex,endIndex));
        //以Page创建PageInfo
        PageInfo pageInfo = new PageInfo<>(page);
        return pageInfo;

    }

}


