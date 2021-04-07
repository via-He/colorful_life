package com.hqq.colorful_life.model.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.dao.CommentMapper;
import com.hqq.colorful_life.model.domain.Comment;
import com.hqq.colorful_life.model.domain.CreateItem;
import com.hqq.colorful_life.model.domain.User;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.domain.Sign;
import com.hqq.colorful_life.model.dao.SignMapper;
import com.hqq.colorful_life.model.service.SignService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class SignServiceImpl implements SignService {

    @Resource
    private SignMapper signMapper;

    @Resource
    private CommentMapper commentMapper;

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

}








