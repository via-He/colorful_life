package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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

    /**
     * 角色控制
     */
    @ApiModelProperty(value = "角色控制")
    private Integer role;
}