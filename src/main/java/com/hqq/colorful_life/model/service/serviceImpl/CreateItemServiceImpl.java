package com.hqq.colorful_life.model.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.filter.UserFilter;
import com.hqq.colorful_life.model.dao.CommentMapper;
import com.hqq.colorful_life.model.domain.Comment;
import com.hqq.colorful_life.model.domain.User;
import com.hqq.colorful_life.model.request.AddCreateItemReq;
import com.hqq.colorful_life.model.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.dao.CreateItemMapper;
import com.hqq.colorful_life.model.domain.CreateItem;
import com.hqq.colorful_life.model.service.CreateItemService;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class CreateItemServiceImpl implements CreateItemService {

    @Resource
    private CreateItemMapper createItemMapper;

    @Resource
    private CommentMapper commentMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (id == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        int i = createItemMapper.deleteByPrimaryKey(id);
        if (i == 0) {
            throw new UniteException(ExceptionEnum.DELETE_FAILED);
        }
        return i;
    }

    @Override
    public int insert(CreateItem record) {
        return createItemMapper.insert(record);
    }

    @Override
    public int insertSelective(CreateItem record) {
        return createItemMapper.insertSelective(record);
    }

    @Override
    public CreateItem selectByPrimaryKey(Integer id) {
        return createItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CreateItem record) {
        return createItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CreateItem record) {
        return createItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public void create(CreateItem createItem) {
        int i = createItemMapper.insertSelective(createItem);
        if (i == 0) {
            throw new UniteException(ExceptionEnum.CREATE_FAILED);
        }
    }

    @Override
    public void addPink(Integer createItemId) {
        if (createItemId == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        CreateItem createItem = createItemMapper.selectByPrimaryKey(createItemId);
        //如果点赞数为null或为0，则值置1，若不为空，则值+1
        Integer pinkNum = createItem.getPinkNum();
        if (pinkNum == null ||pinkNum == 0){
            pinkNum = 1;
        }else {
            pinkNum++;
        }
        createItem.setPinkNum(pinkNum);
        int i = createItemMapper.updateByPrimaryKeySelective(createItem);
        if (i == 0){
            throw new UniteException(ExceptionEnum.UPDATE_FAILED);
        }
    }

    @Override
    public int addComment(Integer createItemId,String comment) {
        if (createItemId == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        CreateItem createItem = createItemMapper.selectByPrimaryKey(createItemId);
        Integer userId = createItem.getUserId();

        //将评论内容添加到评论表
        Comment newComment = new Comment();
        newComment.setUserId(userId);
        newComment.setContent(comment);
        newComment.setCreateId(createItemId);
        int i = commentMapper.insertSelective(newComment);
        if (i == 0){
            throw new UniteException(ExceptionEnum.CREATE_FAILED);
        }
        return i;
    }

    @Override
    public PageInfo listAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        Integer id = UserFilter.currentUser.getId();
        List<CreateItem> createItems = createItemMapper.listAll(id);
        PageInfo<CreateItem> createItemPageInfo = new PageInfo<>(createItems);
        return  createItemPageInfo;
    }

    @Override
    public PageInfo selectByChannelName(Integer pageNum, Integer pageSize, String channelName) {
        PageHelper.startPage(pageNum, pageSize);
        List<CreateItem> createItems = createItemMapper.selectByChannelName(channelName);
        PageInfo<CreateItem> createItemPageInfo = new PageInfo<>(createItems);
        return createItemPageInfo;
    }

    @Override
    public PageInfo listAllForAdmin(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<CreateItem> createItems = createItemMapper.listAllForAdmin();
        PageInfo<CreateItem> createItemPageInfo = new PageInfo<>(createItems);
        return createItemPageInfo;

    }

    @Override
    public List<CreateItem> selectByUserId(Integer userId) {

        PageHelper.startPage(1,10);
        List<CreateItem> createItems = createItemMapper.listAll(userId);
        return createItems;
    }

}





