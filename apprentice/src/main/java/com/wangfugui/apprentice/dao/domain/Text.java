package com.wangfugui.apprentice.dao.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author MaSiyi
 * @version 1.0.0 2021/12/6
 * @since JDK 1.8.0
 */
@Data
public class Text {
    @ApiModelProperty("动态id")
    public Integer dynamicId;

    @ApiModelProperty("博客id")
    public Integer blogId;
}
