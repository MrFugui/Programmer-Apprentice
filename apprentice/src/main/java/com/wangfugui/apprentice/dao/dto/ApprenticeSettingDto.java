package com.wangfugui.apprentice.dao.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/6
 * @since JDK 1.8.0
 */
@Data
public class ApprenticeSettingDto {

    @ApiModelProperty("师徒徒弟类型")
    private String apprenticeValue;

    @ApiModelProperty("拓展信息")
    private ApprenticeSettingExtendDto apprenticeSettingExtendDto;

}
