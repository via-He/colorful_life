package com.hqq.colorful_life.model.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/17 17:40
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.User")
@Data
public class User {
    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 头像
     */
    @ApiModelProperty(value = "头像")
    private String headImage;

    /**
     * 性别：0男；1女
     */
    @ApiModelProperty(value = "性别：0男；1女")
    private Integer sex;

    /**
     * 签名
     */
    @ApiModelProperty(value = "签名")
    private String signature;

    /**
     * 签到内容id
     */
    @ApiModelProperty(value = "签到内容id")
    private Integer signId;

    /**
     * 创作内容id
     */
    @ApiModelProperty(value = "创作内容id")
    private Integer createId;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}