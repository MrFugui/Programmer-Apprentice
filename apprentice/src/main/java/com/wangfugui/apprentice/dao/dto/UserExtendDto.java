package com.wangfugui.apprentice.dao.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户信息拓展表
 * </p>
 *
 * @author MrFugui
 * @since 2021-12-04
 */
@ApiModel(value = "UserExtend对象", description = "用户信息拓展表")
@Data
public class UserExtendDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer extendId;

    @ApiModelProperty("账号名称")
    private String nickName;

    @ApiModelProperty("性别1男0女2不透露")
    private Integer gender;

    @ApiModelProperty("标签")
    private String flag;


}
