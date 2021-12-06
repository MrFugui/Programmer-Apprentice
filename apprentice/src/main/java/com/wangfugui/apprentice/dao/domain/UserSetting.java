package com.wangfugui.apprentice.dao.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户设置表
 * </p>
 *
 * @author MrFugui
 * @since 2021-11-30
 */
@TableName("user_setting")
@ApiModel(value = "UserSetting对象", description = "用户设置表")
@Data
public class UserSetting implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
      @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("用户信息")
    private Integer userId;

    @ApiModelProperty("设置类型")
    private String settingKey;

    @ApiModelProperty("设置值")
    private String settingValue;

    @ApiModelProperty("系统配置表id-默认值")
    private Integer systemConfigId;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;

    @ApiModelProperty("设置模块")
    private String settingGroup;



}
