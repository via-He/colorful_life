package com.hqq.colorful_life.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/22 15:05
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.CreateItem")
@Data
public class CreateItem {
    /**
     * 创作内容id
     */
    @ApiModelProperty(value = "创作内容id")
    private Integer id;

    /**
     * 创作人
     */
    @ApiModelProperty(value = "创作人")
    private Integer userId;

    /**
     * 内容文字
     */
    @ApiModelProperty(value = "内容文字")
    private String content;

    /**
     * 内容的图片或视频的地址
     */
    @ApiModelProperty(value = "内容的图片或视频的地址")
    private String mediaUrl;

    /**
     * 频道标签的选择
     */
    @ApiModelProperty(value = "频道标签的选择")
    private String channelName;

    /**
     * 点赞次数
     */
    @ApiModelProperty(value = "点赞次数")
    private Integer pinkNum;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String comment;

    @ApiModelProperty(value = "null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty(value = "null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}