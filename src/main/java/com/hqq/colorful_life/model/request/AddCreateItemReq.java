package com.hqq.colorful_life.model.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Qingqing.He
 * @date 2021/3/22 15:21
 */
@Data
public class AddCreateItemReq {

    /**
     * 创作人
     */
    @ApiModelProperty(value = "创作人")
    private Integer userId;

    /**
     * 内容文字
     */
    @NotNull(message = "创作内容不能为空")
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

    @ApiModelProperty(value = "null")
    private Date createTime;

    @ApiModelProperty(value = "null")
    private Date updateTime;
}
