package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/17 17:36
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.Recommendation")
@Data
public class Recommendation {
    /**
     * 推荐id
     */
    @ApiModelProperty(value = "推荐id")
    private Integer id;

    /**
     * 管理员id
     */
    @ApiModelProperty(value = "管理员id")
    private Integer sysUserId;

    /**
     * 推荐内容id
     */
    @ApiModelProperty(value = "推荐内容id")
    private Integer createId;

    @ApiModelProperty(value = "null")
    private Date createTime;

    @ApiModelProperty(value = "null")
    private Date updateTime;
}