package com.hqq.colorful_life.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author Qingqing.He
 * @date 2021/3/18 11:27
 */
@Data
public class UpdateUserReq {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String userName;

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

}
