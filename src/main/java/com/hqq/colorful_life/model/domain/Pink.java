package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
*@author Qingqing.He
*@date 2021/3/16 10:46
*/
@ApiModel(value="com.hqq.colorful_life.model.domain.Pink")
@Data
public class Pink {
    /**
    * 点赞id
    */
    @ApiModelProperty(value="点赞id")
    private Integer id;

    /**
    * 点赞人
    */
    @ApiModelProperty(value="点赞人")
    private Integer userId;

    /**
    * 点赞内容
    */
    @ApiModelProperty(value="点赞内容")
    private Integer commentId;
}