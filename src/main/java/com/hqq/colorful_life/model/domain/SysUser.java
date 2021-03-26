package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/22 10:02
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.SysUser")
@Data
public class SysUser {
    /**
     * 管理员id
     */
    @ApiModelProperty(value = "管理员id")
    private Integer id;

    @ApiModelProperty(value = "null")
    private String userName;

    @ApiModelProperty(value = "null")
    private String password;
}