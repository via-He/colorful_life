package com.hqq.colorful_life.model.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hqq.colorful_life.exception.ExceptionEnum;
import com.hqq.colorful_life.exception.UniteException;
import com.hqq.colorful_life.filter.AdminFilter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hqq.colorful_life.model.dao.NoticeMapper;
import com.hqq.colorful_life.model.domain.Notice;
import com.hqq.colorful_life.model.service.NoticeService;

import java.util.List;

/**
 * @author Qingqing.He
 * @date 2021/3/16 10:46
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        if (id == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        int i = noticeMapper.deleteByPrimaryKey(id);
        if (i == 0) {
            throw new UniteException(ExceptionEnum.DELETE_FAILED);
        }
        return i;
    }

    @Override
    public int insert(Notice record) {
        return noticeMapper.insert(record);
    }

    @Override
    public void insertSelective(String record) {
        if (record.isEmpty()) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        Notice notice = new Notice();
        String userName = AdminFilter.currentSysUser.getUserName();
        notice.setCreatorName(userName);
        notice.setContent(record);
        int i = noticeMapper.insertSelective(notice);
        if (i == 0) {
            throw new UniteException(ExceptionEnum.CREATE_FAILED);
        }
    }

    @Override
    public Notice selectByPrimaryKey(Integer id) {
        return noticeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateByPrimaryKeySelective(Notice record) {
        if (record == null) {
            throw new UniteException(ExceptionEnum.REQUEST_PARAM_ERROR);
        }
        noticeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Notice record) {
        return noticeMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageInfo list(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        List<Notice> notices = noticeMapper.selectAllNotice();
        PageInfo<Notice> noticePageInfo = new PageInfo<>(notices);
        return noticePageInfo;
    }

}



