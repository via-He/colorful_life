package com.hqq.colorful_life.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;


/**
*@author Qingqing.He
*@date 2021/3/17 17:11
*/
@ApiModel(value="com.hqq.colorful_life.model.domain.Info")
@Data
public class Info {
    @ApiModelProperty(value="null")
    private Integer id;

    @ApiModelProperty(value="null")
    private String infoColumn;

    @ApiModelProperty(value="null")
    private String infoTittle;

    @ApiModelProperty(value="null")
    private String infoUser;

    @ApiModelProperty(value="null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date infoTime;

    @ApiModelProperty(value="null")
    private String infoUrl;
}