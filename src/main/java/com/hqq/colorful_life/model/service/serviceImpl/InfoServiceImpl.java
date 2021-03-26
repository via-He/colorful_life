package com.hqq.colorful_life.model.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.domain.Info;
import com.hqq.colorful_life.model.dao.InfoMapper;
import com.hqq.colorful_life.model.service.InfoService;

/**
*@author Qingqing.He
*@date 2021/3/17 17:11
*/
@Service
public class InfoServiceImpl implements InfoService{

    @Resource
    private InfoMapper infoMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return infoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Info record) {
        return infoMapper.insert(record);
    }

    @Override
    public int insertSelective(Info record) {
        return infoMapper.insertSelective(record);
    }

    @Override
    public Info selectByPrimaryKey(Integer id) {
        return infoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Info record) {
        return infoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Info record) {
        return infoMapper.updateByPrimaryKey(record);
    }

}
