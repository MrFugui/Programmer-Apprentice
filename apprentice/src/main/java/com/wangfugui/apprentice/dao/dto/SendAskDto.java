package com.wangfugui.apprentice.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/9
 * @since JDK 1.8.0
 */
@ApiModel("发送请求dto")
@Data
public class SendAskDto {

    @ApiModelProperty("请求给")
    Integer toUserId;
    @ApiModelProperty("请求给名字")
    String toUserName;
    @ApiModelProperty("类型")
    Integer askType;
}
