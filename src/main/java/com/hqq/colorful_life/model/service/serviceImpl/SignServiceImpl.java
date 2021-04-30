package com.hqq.colorful_life.model.service.serviceImpl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.dao.CommentMapper;
import com.hqq.colorful_life.model.dao.CreateItemMapper;
import com.hqq.colorful_life.model.domain.Comment;
import com.hqq.colorful_life.model.domain.CreateItem;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.response.MomentAndSignResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.domain.Sign;
import com.hqq.colorful_life.model.dao.SignMapper;
import com.hqq.colorful_life.model.service.SignService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Slf4j
@Service
public class SignServiceImpl implements SignService {

    @Resource
    private SignMapper signMapper;

    @Resource
    private CommentMapper commentMapper;

    @Resource
    private CreateItemMapper createItemMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return signMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Sign record) {
        return signMapper.insert(record);
    }

    @Override
    public int insertSelective(Sign record) {
        return signMapper.insertSelective(record);
    }

    @Override
    public Sign selectByPrimaryKey(Integer id) {
        if (id == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        return signMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Sign record) {
        return signMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Sign record) {
        return signMapper.updateByPrimaryKey(record);
    }

    @Override
    public int addComment(Integer signId, String comment) {
        if (signId == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        Sign sign = signMapper.selectByPrimaryKey(signId);
        Integer userId = sign.getUserId();

        //将评论内容添加到评论表
        Comment newComment = new Comment();
        newComment.setUserId(userId);
        newComment.setContent(comment);
        newComment.setSignId(signId);
        int i = commentMapper.insertSelective(newComment);
        if (i == 0) {
            throw new UniteException(ExceptionEnum.CREATE_FAILED);
        }
        return i;
    }

    @Override
    public PageInfo selectSignList(Integer pageNum, Integer pageSize) {

        Integer userId = UserFilter.currentUser.getId();
        PageHelper.startPage(pageNum, pageSize);
        List<Sign> signs = signMapper.selectAllSign(userId);
        PageInfo<Sign> signPageInfo = new PageInfo<>(signs);
        return signPageInfo;
    }

    @Override
    public Integer selectSignNum(Integer userId) {
        Integer signNum = signMapper.selectSignNum(userId);
        return signNum;
    }

    @Override
    public PageInfo listSignByChannelName(Integer pageNum, Integer pageSize, String channelName) {

        PageHelper.startPage(pageNum, pageSize);
        List<Sign> signs = signMapper.selectByChannelName(channelName);
        PageInfo<Sign> signPageInfo = new PageInfo<>(signs);
        return signPageInfo;
    }

    @Override
    public PageInfo listAllByChannelName(Integer pageNum, Integer pageSize, String channelName) {
        List<Sign> signs = signMapper.selectByChannelName(channelName);
        List<CreateItem> createItems = createItemMapper.selectByChannelName(channelName);
        PageHelper.startPage(pageNum, pageSize);
        List<MomentAndSignResp> momentAndSignResps = new ArrayList<MomentAndSignResp>();
        for (int i = 0; i < signs.size(); i++) {
            MomentAndSignResp momentAndSignResp = new MomentAndSignResp();
            Sign sign = signs.get(i);
            momentAndSignResp.setSignId(sign.getId());
            momentAndSignResp.setSignUserId(sign.getUserId());
            momentAndSignResp.setTitle(sign.getTitle());
            momentAndSignResp.setSignContent(sign.getContent());
            momentAndSignResp.setChannelName(sign.getChannelName());
            momentAndSignResp.setSignMediaUrl(sign.getMediaUrl());
            momentAndSignResp.setSignPinkNum(sign.getPinkNum());
            momentAndSignResp.setSignUpdateTime(sign.getUpdateTime());
            momentAndSignResps.add(momentAndSignResp);
        }
        for (int i = 0; i < createItems.size(); i++) {
            MomentAndSignResp momentAndSignResp = new MomentAndSignResp();
            CreateItem createItem = createItems.get(i);
            momentAndSignResp.setCreateId(createItem.getId());
            momentAndSignResp.setCreateUserId(createItem.getUserId());
            momentAndSignResp.setCreateContent(createItem.getContent());
            momentAndSignResp.setChannelName(createItem.getChannelName());
            momentAndSignResp.setCreateMediaUrl(createItem.getMediaUrl());
            momentAndSignResp.setCreatePinkNum(createItem.getPinkNum());
            momentAndSignResp.setCreateUpdateTime(createItem.getUpdateTime());
            momentAndSignResps.add(momentAndSignResp);
        }
        log.info("momentAndSignResps:{}"+momentAndSignResps);
        //创建Page类
        Page page = new Page(pageNum, pageSize);
        //为Page类中的total属性赋值
        int total = momentAndSignResps.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (pageNum -1)*pageSize;
        int endIndex = Math.min(startIndex + pageSize,total);
        //从链表中截取需要显示的子链表，并加入到Page
        page.addAll(momentAndSignResps.subList(startIndex,endIndex));
        //以Page创建PageInfo
        PageInfo pageInfo = new PageInfo<>(page);
        return pageInfo;
    }

    @Override
    public PageInfo listSignForAdmin(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<Sign> signs = signMapper.listSignForAdmin();
        PageInfo<Sign> signPageInfo = new PageInfo<>(signs);
        return signPageInfo;
    }

    @Override
    public List<Sign> selectByUserId(Integer userId) {

        PageHelper.startPage(1,10);
        List<Sign> signs = signMapper.selectAllSign(userId);
        return signs;
    }

}









