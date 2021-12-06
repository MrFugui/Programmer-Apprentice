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

    private Integer id;

    @ApiModelProperty("用户id")
    private Integer userId;

    @ApiModelProperty("邮箱")
    private Integer emailId;

    @ApiModelProperty("账号名称")
    private String nickName;

    @ApiModelProperty("手机号码")
    private String phone;

    @ApiModelProperty("性别1男0女2不透露")
    private Integer gender;

    @ApiModelProperty("标签")
    private String flag;


}
