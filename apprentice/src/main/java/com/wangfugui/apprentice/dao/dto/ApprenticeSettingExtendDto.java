package com.wangfugui.apprentice.dao.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/6
 * @since JDK 1.8.0
 */
@Data
public class ApprenticeSettingExtendDto {

    @ApiModelProperty("个人简介")
    private String personalProfile;

    @ApiModelProperty("标签")
    private String label;

    @ApiModelProperty("想找什么样的师傅或徒弟")
    private String wantApprentice;
}
