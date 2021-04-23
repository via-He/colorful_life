package com.hqq.colorful_life.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
 * @author Qingqing.He
 * @date 2021/3/22 15:06
 */
@ApiModel(value = "com.hqq.colorful_life.model.domain.Notice")
@Data
public class Notice {
    /**
     * 公告id
     */
    @ApiModelProperty(value = "公告id")
    private Integer id;

    /**
     * 发布者
     */
    @ApiModelProperty(value = "发布者")
    private String creatorName;

    /**
     * 发布内容
     */
    @ApiModelProperty(value = "发布内容")
    private String content;

    @ApiModelProperty(value = "null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    @ApiModelProperty(value = "null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}