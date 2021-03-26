package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/23 10:45
 */
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
    private Date createTime;
}