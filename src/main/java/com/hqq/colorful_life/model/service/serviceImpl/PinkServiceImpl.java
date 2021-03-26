package com.hqq.colorful_life.model.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.dao.PinkMapper;
import com.hqq.colorful_life.model.domain.Pink;
import com.hqq.colorful_life.model.service.PinkService;

/**
*@author Qingqing.He
*@date 2021/3/16 10:46
*/
@Service
public class PinkServiceImpl implements PinkService{

    @Resource
    private PinkMapper pinkMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return pinkMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Pink record) {
        return pinkMapper.insert(record);
    }

    @Override
    public int insertSelective(Pink record) {
        return pinkMapper.insertSelective(record);
    }

    @Override
    public Pink selectByPrimaryKey(Integer id) {
        return pinkMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Pink record) {
        return pinkMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Pink record) {
        return pinkMapper.updateByPrimaryKey(record);
    }

}
