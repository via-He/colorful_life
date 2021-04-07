package com.hqq.colorful_life.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/4/6 13:38
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.Sign")
@Data
public class Sign {
    /**
     * 签到id
     */
    @ApiModelProperty(value = "签到id")
    private Integer id;

    /**
     * 签到用户
     */
    @ApiModelProperty(value = "签到用户")
    private Integer userId;

    /**
     * 签到标题
     */
    @ApiModelProperty(value = "签到标题")
    private String title;

    /**
     * 签到内容
     */
    @ApiModelProperty(value = "签到内容")
    private String content;

    /**
     * 媒体地址
     */
    @ApiModelProperty(value = "媒体地址")
    private String mediaUrl;

    /**
     * 频道：1学习；2成长；3情感；4思想；5美食；6：旅游
     */
    @ApiModelProperty(value = "频道：1学习；2成长；3情感；4思想；5美食；6：旅游")
    private String channelName;

    /**
     * 点赞次数
     */
    @ApiModelProperty(value = "点赞次数")
    private Long pinkNum;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String comment;

    /**
     * 签到次数
     */
    @ApiModelProperty(value = "签到次数")
    private Integer signNum;

    /**
     * 签到状态：0未签到；1已签到
     */
    @ApiModelProperty(value = "签到状态：0未签到；1已签到")
    private Integer signStatus;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 签到时间
     */
    @ApiModelProperty(value = "签到时间")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

}