package com.hqq.colorful_life.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@ApiModel(value = "com.hqq.colorful_life.model.domain.Comment")
@Data
public class Comment {
    /**
     * 评论id
     */
    @ApiModelProperty(value = "评论id")
    private Integer id;

    /**
     * 评论用户
     */
    @ApiModelProperty(value = "评论用户")
    private Integer userId;

    @ApiModelProperty(value = "null")
    private Integer createId;

    /**
     * 评论者
     */
    @ApiModelProperty(value = "评论者")
    private Integer reviewer;

    @ApiModelProperty(value = "null")
    private Integer signId;

    /**
     * 评论内容
     */
    @ApiModelProperty(value = "评论内容")
    private String content;

    /**
     * 评论时间
     */
    @ApiModelProperty(value = "评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
}