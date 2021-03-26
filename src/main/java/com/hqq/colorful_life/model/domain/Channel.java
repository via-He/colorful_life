package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/17 17:11
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.Channel")
@Data
public class Channel {
    /**
     * 频道id
     */
    @ApiModelProperty(value = "频道id")
    private Integer id;

    /**
     * 频道名称
     */
    @ApiModelProperty(value = "频道名称")
    private String name;
}