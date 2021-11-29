package com.wangfugui.apprentice.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/11/29
 * @since JDK 1.8.0
 */
@ApiModel("代码生成器dto类")
@Data
public class GeneratorDto {

    @ApiModelProperty("项目位置")
    private String dirUrl;

    @ApiModelProperty("表名称")
    private String tableName;

    @ApiModelProperty("作者名称")
    private String authName;
}
