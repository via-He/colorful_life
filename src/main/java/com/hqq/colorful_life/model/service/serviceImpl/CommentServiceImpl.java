package com.hqq.colorful_life.model.service.serviceImpl;

import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.filter.UserFilter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.dao.CommentMapper;
import com.hqq.colorful_life.model.domain.Comment;
import com.hqq.colorful_life.model.service.CommentService;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (id == null){
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public Comment selectByPrimaryKey(Integer id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<String> detail(Integer createItemId) {
        if (createItemId == null){
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        List<String> content = commentMapper.ItemDetail(createItemId);
        return content;
    }

    @Override
    public List<String> SignDetail(Integer signId) {
        if (signId == null){
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        List<String> content = commentMapper.SignDetail(signId);
        return content;
    }

}




