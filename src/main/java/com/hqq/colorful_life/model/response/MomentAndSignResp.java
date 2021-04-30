package com.hqq.colorful_life.model.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class MomentAndSignResp {
    /**
     * 签到id
     */
    @ApiModelProperty(value = "签到id")
    private Integer signId;

    /**
     * 创作内容id
     */
    @ApiModelProperty(value = "创作内容id")
    private Integer createId;

    /**
     * 签到用户
     */
    @ApiModelProperty(value = "签到用户")
    private Integer signUserId;

    /**
     * 创作人
     */
    @ApiModelProperty(value = "创作人")
    private Integer createUserId;

    /**
     * 签到标题
     */
    @ApiModelProperty(value = "签到标题")
    private String title;

    /**
     * 签到内容
     */
    @ApiModelProperty(value = "签到内容")
    private String signContent;

    /**
     * 内容文字
     */
    @ApiModelProperty(value = "内容文字")
    private String createContent;

    /**
     * 媒体地址
     */
    @ApiModelProperty(value = "媒体地址")
    private String signMediaUrl;

    /**
     * 内容的图片或视频的地址
     */
    @ApiModelProperty(value = "内容的图片或视频的地址")
    private String createMediaUrl;

    /**
     * 频道：1学习；2成长；3情感；4思想；5美食；6：旅游
     */
    @ApiModelProperty(value = "频道：1学习；2成长；3情感；4思想；5美食；6：旅游")
    private String channelName;

    /**
     * 点赞次数
     */
    @ApiModelProperty(value = "点赞次数")
    private Long signPinkNum;


    /**
     * 点赞次数
     */
    @ApiModelProperty(value = "点赞次数")
    private Integer createPinkNum;

    /**
     * 签到时间
     */
    @ApiModelProperty(value = "签到时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date signUpdateTime;

    @ApiModelProperty(value = "null")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createUpdateTime;
}
