package com.hqq.colorful_life.model.service.serviceImpl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.domain.Channel;
import com.hqq.colorful_life.model.dao.ChannelMapper;
import com.hqq.colorful_life.model.service.ChannelService;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class ChannelServiceImpl implements ChannelService {

    @Resource
    private ChannelMapper channelMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return channelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Channel record) {
        return channelMapper.insert(record);
    }

    @Override
    public int insertSelective(Channel record) {
        return channelMapper.insertSelective(record);
    }

    @Override
    public Channel selectByPrimaryKey(Integer id) {
        return channelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Channel record) {
        return channelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Channel record) {
        return channelMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> listChannel() {

        List<String> channelName = channelMapper.selectAllChannelName();
        return channelName;
    }

}

