package com.hqq.colorful_life.model.service;

import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.model.domain.CreateItem;
import com.hqq.colorful_life.model.request.AddCreateItemReq;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
public interface CreateItemService {


    int deleteByPrimaryKey(Integer id);

    int insert(CreateItem record);

    int insertSelective(CreateItem record);

    CreateItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreateItem record);

    int updateByPrimaryKey(CreateItem record);

    void create(AddCreateItemReq addCreateItemReq);

    void addPink(Integer createItemId);

    int addComment(Integer createItemId, String comment);

    PageInfo listAll(Integer pageNum,Integer pageSize);

    PageInfo selectByChannelName(Integer pageNum, Integer pageSize, String channelName);

    PageInfo listAllForAdmin(Integer pageNum, Integer pageSize);
}




